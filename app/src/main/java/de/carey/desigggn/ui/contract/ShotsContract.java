package de.carey.desigggn.ui.contract;


import java.util.List;

import de.carey.desigggn.base.BasePresenter;
import de.carey.desigggn.base.BaseView;
import de.carey.desigggn.entity.ShotEntity;

public interface ShotsContract {

    interface View extends BaseView {

        void showShots(List<ShotEntity> shots);

        void showError(String msg);
    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getShots(String type, String sort, String time, int pageIndex);
    }
}
