package de.carey.desigggn.base;

import android.databinding.ViewDataBinding;

public abstract class BaseMVPActivity<P extends BasePresenter, B extends ViewDataBinding> extends BaseActivity<B> {

    protected P mPresenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void initPresenter() {
        mPresenter = TUtil.getT(this, 0);
        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.setView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetached();
            mPresenter = null;
        }
    }
}
