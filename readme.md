1.文件介绍
	credit.sql：数据库脚本文件,使用mysql数据库
	后台：java后台代码，编译器为myeclipse
	CreditWorld: android端代码，编译器为androidstudio
	html: 网页版源代码

2.使用方法
	1.在数据库中创建相应表
	2.用myeclipse打开后台代码，修改config/spring-hibernate.xml中的数据库配置信息（用户名，密码）
	3.启动tomcat服务器
	4.打开html/www/index.html即可运行

3.备注，
1.因为没有网络服务器，所以android端暂时无法运行，如果想使用app需要将代码上传到sae等平台上，
并修改CreditWorld\app\src\main\assets\www\js\base.js 中的url参数

2.如果服务器访问地址不是localhost：8080/CreditWorld，那么需要手动修改base.js中的url参数
（html/www/js/base.js和CreditWorld\app\src\main\assets\www\js\base.js）

3.没有苹果本，暂时无法提供ios端代码

4.后台采用ssh框架，数据传输采用ajax，前端采用jquerymobile框架，JavaScript全部采用jquery实现

5.因为最近事情比较多，公司项目上线推广，没有太多的时间来写，所以界面没怎么设计，可以自己修改相应css代码来是界面更加美观

6.测试什么的直接用html文件里的代码就够了，android端如果要使用需要做很多修改及配置。


大概就是这样
