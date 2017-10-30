package de.carey.desigggn.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

public interface BaseView {

    void onComplete();

    void showLoading();

    void showToast(String msg);

    <T> LifecycleTransformer<T> bindLifecycle();
}
