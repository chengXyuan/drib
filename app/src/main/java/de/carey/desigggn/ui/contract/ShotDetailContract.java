package de.carey.desigggn.ui.contract;

import java.util.List;

import de.carey.desigggn.base.BasePresenter;
import de.carey.desigggn.base.BaseView;
import de.carey.desigggn.entity.CommentEntity;

public interface ShotDetailContract {

    interface View extends BaseView {

        void showComments(List<CommentEntity> data);
    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getComments(String url);
    }
}
