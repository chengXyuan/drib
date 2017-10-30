package de.carey.desigggn.ui.contract;

import de.carey.desigggn.base.BasePresenter;
import de.carey.desigggn.base.BaseView;
import de.carey.desigggn.entity.UserEntity;

public interface MainContract {

    interface View extends BaseView {

        void refreshUserInfo(UserEntity user);
    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getAccessToken(String code);

        public abstract void getUserInfo();
    }
}
