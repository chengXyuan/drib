package de.carey.desigggn.ui.presenter;

import de.carey.desigggn.app.Cons;
import de.carey.desigggn.base.BaseSubscriber;
import de.carey.desigggn.entity.UserEntity;
import de.carey.desigggn.helper.UserInfoManager;
import de.carey.desigggn.ui.contract.MainContract;
import de.carey.desigggn.util.RxSchedulers;
import de.carey.desigggn.util.SPUtils;

public class MainPresenter extends MainContract.Presenter {

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
                .subscribe(new BaseSubscriber<UserEntity>() {
                    @Override
                    protected void onSuccess(UserEntity data) {
                        UserInfoManager.setUserInfo(data);
                        mView.refreshUserInfo(data);
                    }

                    @Override
                    protected void onFailure(String code, String msg) {
                        UserInfoManager.setUserInfo(null);
                        mView.refreshUserInfo(null);
                    }
                });
    }
}
