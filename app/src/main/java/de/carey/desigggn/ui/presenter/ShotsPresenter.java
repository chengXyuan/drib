package de.carey.desigggn.ui.presenter;

import java.util.List;

import de.carey.desigggn.app.Cons;
import de.carey.desigggn.base.BaseSubscriber;
import de.carey.desigggn.entity.ShotEntity;
import de.carey.desigggn.ui.contract.ShotsContract;
import de.carey.desigggn.util.RxSchedulers;

public class ShotsPresenter extends ShotsContract.Presenter {

    @Override
    public void getShots(String type, String sort, String time, int pageIndex) {
        mNetRepository.getShotsList(type, sort, time, pageIndex, Cons.PAGE_SIZE)
                .compose(RxSchedulers.io2Main())
                .compose(mView.bindLifecycle())
                .subscribeWith(new BaseSubscriber<List<ShotEntity>>(mView) {
                    @Override
                    protected void onSuccess(List<ShotEntity> shotEntities) {
                        mView.showShots(shotEntities);
                    }

                    @Override
                    protected void onFailure(String code, String message) {
                        mView.showError(message);
                    }
                });
    }
}
