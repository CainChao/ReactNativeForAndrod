# ExampleInterface.java��һ��ʵ��ReactContextBaseJavaModule �ӿ��ļ�������Ҫ����ʵ��React-Native(RN)��ԭ��ͨ�š�
#ʵ�ֲ���:
	
#steps1��дһ����ʵ��ReactContextBaseJavaModule��дgetName�����������������ַ��ء�
	
#steps2��дһ����ʵ��ReactPackage ʵ�������createNativeModules��createJSModules��createViewManagers����������createNativeModules�����м��뿪���Ľӿڡ�
	
#steps3����MainApplication.java�ļ���getPackages�ķ����н�ǰ��ReactPackage��ʵ�������ע�ᡣ

#����Ǵ�RN��ֵ��ԭ����Ҫ��ExampleInterface��д�ص������÷��������з���ֵ��������Ҫ@ReactMethod����ע�ͣ���RN�Ǳ�ʹ��NativeModules.ExampleInterface.xxx(��Ҫ����ֵ)

#����Ǵ�ԭ����ֵ��RNʹ��mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("AndroidToRNMessage",mMessage);���д�ֵ����RNʹ��DeviceEventEmitter.addListener('AndroidToRNMessage',listener)����ȡֵ
	