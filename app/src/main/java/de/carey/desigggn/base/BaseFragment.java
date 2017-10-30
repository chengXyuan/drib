package de.carey.desigggn.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseFragment<B extends ViewDataBinding> extends RxFragment {

    protected B mViewBinding;
    protected FragmentActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);
        return mViewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        initPresenter();
        initData(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (useEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (useEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * @return 是否使用EventBus接收消息, 默认false, 如需使用重新该方法返回true
     */
    protected boolean useEventBus() {
        return false;
    }

    public void onComplete() {

    }

    public void showLoading() {

    }

    public void showToast(String msg) {

    }

    public <T> LifecycleTransformer<T> bindLifecycle() {
        return bindUntilEvent(FragmentEvent.DESTROY_VIEW);
    }

    protected void initPresenter() {
        //MVP写法的Fragment实现
    }

    protected abstract int getLayoutResId();

    protected abstract void initData(Bundle savedInstanceState);
}
