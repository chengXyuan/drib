package de.carey.desigggn.base;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity<B extends ViewDataBinding> extends RxAppCompatActivity {

    protected B mViewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutResId());
        initStatusBar();
        initPresenter();
        initData(savedInstanceState);
    }

    protected void initStatusBar() {
        //需要修改状态栏颜色的重写该方法.
    }

    protected void initPresenter() {
        //MVP写法的Activity中实现
    }

    @Override
    protected void onStart() {
        super.onStart();
        //按需注册EventBus
        if (useEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //按需注销EventBus
        if (useEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

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
        return bindUntilEvent(ActivityEvent.DESTROY);
    }

    protected abstract int getLayoutResId();

    protected abstract void initData(Bundle savedInstanceState);
}
