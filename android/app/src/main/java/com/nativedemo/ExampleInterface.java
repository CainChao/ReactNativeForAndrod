package com.nativedemo;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/**
 * Author YC
 * 2016/7/13 0013.
 */
public class ExampleInterface extends ReactContextBaseJavaModule {
    private ReactApplicationContext mContext;
    public ExampleInterface(ReactApplicationContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
    }
    @Override
    public String getName() {
        return "ExampleInterface";
    }
    /**
     * 原生代码处理消息的函数
     * 必须使用@ReactMethod关键字注释为一个React函数才能被调用，不能有返回值,只能传一个参数
     * @param
     */
    @ReactMethod
    public void HandleMessage(String tableName,String name){
        Log.e("tableName",tableName);
        Log.e("name",name);
//        // 创建数据库
//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
//                getReactApplicationContext().getApplicationContext().getCacheDir() + "/test.db", null);
//        // 创建表
//        String schema = "create table student(_id integer primary key "
//                + "autoincrement, name, sex, birthday)";
//        db.execSQL(schema);
//
//        // 关闭数据库
//        db.close();
 //       dataBase = new CreateDataBase(getReactApplicationContext(),tableName);
        Intent intent = new Intent(mContext,Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
    /**
     * 向RN发送消息
     * @param mMessage
     */
    public void sendMessage(String mMessage){
        mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("AndroidToRNMessage",mMessage);
    }

    /**
     * 回调方法
     * @param name
     * @param callback
     */
    @ReactMethod
    public void HandleMessageMethod(String name, Callback callback){
        callback.invoke(name);
    }
    @ReactMethod
    public void HandlePromise(String name, Promise promise){
        try{
            //对应React-Native的Promise执行成功
            promise.resolve(name);
        }catch (Exception e){
            //对应React-Native的Promise执行失败
            promise.reject("error",e.toString());
        }

    }
}
