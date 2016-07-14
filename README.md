# ExampleInterface.java是一个实现ReactContextBaseJavaModule 接口文件，是主要负责实现React-Native(RN)和原生通信。
#实现步骤:
	
#steps1：写一个类实现ReactContextBaseJavaModule重写getName方法，将这个类的名字返回。
	
#steps2：写一个类实现ReactPackage 实现里面的createNativeModules、createJSModules、createViewManagers方法并且在createNativeModules方法中加入开发的接口。
	
#steps3：在MainApplication.java文件中getPackages的方法中将前面ReactPackage是实现类进行注册。

#如果是从RN传值到原生需要在ExampleInterface中写回调方法该方法不能有返回值，必须需要@ReactMethod进行注释，在RN那边使用NativeModules.ExampleInterface.xxx(需要传的值)

#如果是从原生传值到RN使用mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("AndroidToRNMessage",mMessage);进行传值，在RN使用DeviceEventEmitter.addListener('AndroidToRNMessage',listener)进行取值
	