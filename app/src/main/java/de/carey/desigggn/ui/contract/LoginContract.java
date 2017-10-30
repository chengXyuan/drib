package de.carey.desigggn.ui.contract;

import de.carey.desigggn.base.BasePresenter;
import de.carey.desigggn.base.BaseView;

public interface LoginContract {

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getAccessToken(String code);

        public abstract void getUserInfo();
    }
}
