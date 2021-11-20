package com.huqi.renamedemo;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;

import com.tencent.test.LifecycleO;

public class TestHello extends Handler implements LifecycleO {
    public TestHello(Activity activity) {
        Log.e("Magnus", "act:" + activity);
    }

    public void f() {
        Log.e("Magnus", "hello");
    }

}
