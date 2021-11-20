package com.huqi.renamedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.special.home.SecondActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}