package com.special.home;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.huqi.renamedemo.R;
import com.huqi.renamedemo.TestHello;
import com.huqi.renamedemo.handler.LifecycleHandler;

public class SecondActivity extends FragmentActivity {

    private static final int UPDATE_BTN_COUNT_DOWN = 0x0001;
    private static int COUNT_DOWN_TIMES = 3;
    public LifecycleHandler mHandler = new LifecycleHandler(this){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (COUNT_DOWN_TIMES > 0) {
                COUNT_DOWN_TIMES--;
                initCleanBtn();
                mHandler.sendEmptyMessageDelayed(UPDATE_BTN_COUNT_DOWN, 1000);
            }
        }
    };

    private TestHello testHello = new TestHello(this) {
        @Override
        public void f() {
            super.f();
            Log.e("Magnus", "hello f");
        }
    };

    private void initCleanBtn(){
        ((TextView)findViewById(R.id.name)).setText("1231231231");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        testHello.f();
    }

}
