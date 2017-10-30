package de.carey.desigggn.ui.presenter;

import de.carey.desigggn.app.Cons;
import de.carey.desigggn.helper.UserInfoManager;
import de.carey.desigggn.ui.contract.LoginContract;
import de.carey.desigggn.util.RxSchedulers;
import de.carey.desigggn.util.SPUtils;

public class LoginPresenter extends LoginContract.Presenter {

    @Override
    public void getAccessToken(String code) {
        mNetRepository.getAccessToken(code)
                .compose(RxSchedulers.io2Main())
                .compose(mView.bindLifecycle())
                .subscribe(tokenEntity -> {
                    SPUtils.putString(Cons.SP_ACCESS_TOKEN, tokenEntity.getAccessToken());
                    getUserInfo();
                });
    }

    @Override
    public void getUserInfo() {
        mNetRepository.getUserInfo()
                .compose(RxSchedulers.io2Main())
                .compose(mView.bindLifecycle())
                .subscribe(UserInfoManager::setUserInfo);
    }
}
