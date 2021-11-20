package com.huqi.renamedemo.handler;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecycleHandler extends Handler implements LifecycleObserver {

    private static final String TAG = "[LifecycleHandler]";
    private LifecycleOwner mLifecycleOwner;

    public LifecycleHandler(LifecycleOwner mLifecycleOwner) {
        this.mLifecycleOwner = mLifecycleOwner;
        addObserver();
    }

    public LifecycleHandler(@Nullable Callback callback, LifecycleOwner mLifecycleOwner) {
        super(callback);
        this.mLifecycleOwner = mLifecycleOwner;
        addObserver();
    }

    public LifecycleHandler(@NonNull Looper looper, LifecycleOwner mLifecycleOwner) {
        super(looper);
        this.mLifecycleOwner = mLifecycleOwner;
        addObserver();
    }

    public LifecycleHandler(@NonNull Looper looper, @Nullable Callback callback, LifecycleOwner mLifecycleOwner) {
        super(looper, callback);
        this.mLifecycleOwner = mLifecycleOwner;
        addObserver();
    }

    private void addObserver() {
        Log.e(TAG, "addObserver: " );
        mLifecycleOwner.getLifecycle().addObserver(this);
    }

    public void removeLoop() {
        Log.e(TAG, "removeLoop: ");
        removeCallbacksAndMessages(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        removeCallbacksAndMessages(null);
        mLifecycleOwner.getLifecycle().removeObserver(this);
    }
}