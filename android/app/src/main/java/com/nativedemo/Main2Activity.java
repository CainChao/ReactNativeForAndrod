package com.nativedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }
    public void Btn1_Click(View view){
            MainApplication  application =(MainApplication) getApplication();
            application.anExampleReactPackage.rnExampleInterface.sendMessage("测试");
//        Intent intent = new Intent(Main2Activity.this,MainActivity.class);
//        startActivity(intent);
    }

}
