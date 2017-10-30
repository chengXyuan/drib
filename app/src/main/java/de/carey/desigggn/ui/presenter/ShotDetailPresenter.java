package de.carey.desigggn.ui.presenter;

import java.util.List;

import de.carey.desigggn.api.NetRepository;
import de.carey.desigggn.base.BaseSubscriber;
import de.carey.desigggn.entity.CommentEntity;
import de.carey.desigggn.ui.contract.ShotDetailContract;
import de.carey.desigggn.util.RxSchedulers;

public class ShotDetailPresenter extends ShotDetailContract.Presenter {

    @Override
    public void getComments(String url){
        NetRepository.get().getComments(url)
                .compose(RxSchedulers.io2Main())
                .compose(mView.bindLifecycle())
                .subscribeWith(new BaseSubscriber<List<CommentEntity>>() {
                    @Override
                    protected void onSuccess(List<CommentEntity> data) {
                        mView.showComments(data);
                    }

                    @Override
                    protected void onFailure(String code, String msg) {

                    }
                });
    }
}
