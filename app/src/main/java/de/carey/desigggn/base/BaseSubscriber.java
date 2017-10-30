package de.carey.desigggn.base;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import de.carey.desigggn.app.App;
import de.carey.desigggn.util.NetWorkUtils;
import io.reactivex.subscribers.DisposableSubscriber;

public abstract class BaseSubscriber<T> extends DisposableSubscriber<T> {

    private BaseView mView;
    private boolean mIsShowLoading;

    public BaseSubscriber() {

    }

    public BaseSubscriber(BaseView view) {
        mView = view;
    }

    public BaseSubscriber(BaseView view, boolean isShowLoading) {
        mView = view;
        mIsShowLoading = isShowLoading;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!NetWorkUtils.isAvailable(App.getAppContext())) {
            cancel();
            onFailure("0x01", "当前网络不可用, 请检查网络连接后重试!");
        } else if (mView != null && mIsShowLoading) {
            mView.showLoading();
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        if (mView != null) {
            mView.onComplete();
        }
        if (t instanceof SocketTimeoutException) {
            onFailure("0x02", "服务器响应超时!");
        } else if (t instanceof ConnectException) {
            onFailure("0x03", "请求超时, 请检查您的网络是否正常!");
        } else if (t instanceof UnknownHostException) {
            onFailure("0x04", "DNS解析出错!");
        } else {
            onFailure("0x05", "出错了哦, 请您稍后再试");
        }
    }

    @Override
    public void onComplete() {
        if (mView != null) {
            mView.onComplete();
        }
    }

    protected abstract void onSuccess(T data);

    protected abstract void onFailure(String code, String msg);
}
