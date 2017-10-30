package de.carey.desigggn.base;


import org.greenrobot.eventbus.EventBus;

import de.carey.desigggn.api.NetRepository;

public abstract class BasePresenter<V> {

    protected V mView;
    protected NetRepository mNetRepository;

    public void setView(V view) {
        mView = view;
        mNetRepository = NetRepository.get();
        onAttached();
    }

    protected void onAttached() {
        if (useEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    protected void onDetached() {
        if (useEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        mView = null;
    }

    protected boolean useEventBus() {
        return false;
    }
}
