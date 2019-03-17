## 抓包
用到工具
* 代理工具 fiddler
* 抓包工具 Wireshark
* http请求 postman

## 反编译
用到的工具
* android killer
* apkToolKit



## 框架搭建
* 数据库是否使用框架（greendao）
* 网络请求（okhttp，retrofit）
* UncaughtExceptionHandler 实现
  ` mDefaultHandler=Thread.getDefaultUncaughtExceptionHandler();
        // 设置该 CrashHandler 为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);`

* 异常上报分析（友盟、bugly）方便自己
* 图片加载（glide、imageloader、picssio）
* 持久化 sp、db、file
	* sp 文件名升级兼容
	* db 表升级、直接删表升级
	* file  
* jni 应用场景（涉及到加解密、图片处理等其他需要保护的算法）
	* 参考手册
* json解析
	* 抽取解析方法放到父类里面
* gradle
    * 混淆
    * 高阶：可自定义buildConfig参数`buildConfigField("int", "API_HOST_TYPE", "${API_PRO_TYPE}")`
    * 加壳（腾讯云加固、360加壳）加壳后记得测试
    * 
    
    
## 3.17
* activity 启动方式，生命周期
* fragment 
* broadcast 两种方式 使用场景 (eventbus)  `LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);`
* service 场景 线程问题、启动绑定
* 自定义组件
* gradle 配置脚本依赖
* jcenter 上传流程，gradle脚本
* gradle 变量声明、模块gradle引用变量