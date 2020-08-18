原链接：https://github.com/yuxin5836/a-wechat-game

此版本相当于是一个较为靠后的完成版本



前端界面（包括大厅，商城，各个主界面之间的切换等等）由yc同学提供，

圈地算法和摇杆的脚本和界面由zwl同学提供，

我写了地图界面+地图运行时圈地的脚本和服务器端，登录界面以及将所有工作串联起来。





在没有配置好环境之前本工程运行是不会有任何效果的！

环境：

cocos creator v2.3.3

mysql 8.0.19

jdk 8

eclipse

tomcat v8.0+eclipse的tomcat插件



运行时需要先运行tomcat_websocket下的sql文件

然后需要重新配置服务器端的mysql的USER,PASSWORD和URL

```js
var webSocket = 
            new WebSocket('ws://localhost:8080/tomcat_websocket/test');
```

websocket的连接地址如果你改了项目名就要跟着修改

test是一个java的servlet源文件，在src/main目录下





可以完善的地方：

添加道具购买（已经从数据库中读出来了，但是更新数据库模块没有写）

添加碰壁之后game over

添加道具使用模块

联机对战模块（太难了，不想做了）




