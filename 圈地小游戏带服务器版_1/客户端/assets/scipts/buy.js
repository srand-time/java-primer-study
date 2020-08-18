// Learn cc.Class:
//  - https://docs.cocos.com/creator/manual/en/scripting/class.html
// Learn Attribute:
//  - https://docs.cocos.com/creator/manual/en/scripting/reference/attributes.html
// Learn life-cycle callbacks:
//  - https://docs.cocos.com/creator/manual/en/scripting/life-cycle-callbacks.html

cc.Class({
    extends: cc.Component,

    properties: {
        label_cash: {
            default: null,
            type: cc.Label
        },
        label_re: {
            default: null,
            type: cc.Label
        },
        label_acc: {
            default: null,
            type: cc.Label
        }
    },

    start(){
        this.initSocket();
    },

    update(){
        this.label_cash.string=cash;
        this.label_acc.string=acc_prop;
        this.label_re.string=re_prop;
    },
            
        //初始化与服务器建立连接
            initSocket: function(){
                if(window.WebSocket){
                    var wsUri = "ws://localhost:8080/tomcat_websocket/buy";
                    websocket = new WebSocket(wsUri);
                    //websocket.binaryType = "arraybuffer";
                    //var mythis = this;
                    //连接到服务器后执行
                    websocket.onopen = function(event) {
                        console.log("connect");
                        //mythis.requestInitInfoBar();
                    };
            
                    //断开服务器连接后执行
                    websocket.onclose = function(event) {
                        websocket.close();
                        console.log("closed");
                    };
            
                    //接收服务器传递的消息后执行
                    websocket.onmessage = function(event) {
                        if(event.data.substr(0,2)=='fa')//密码错误
                            alert("fail to login,wrong secret code");
                        else if(event.data.substr(0,2)=='ac') //服务器发送的是加速道具数目
                            acc_prop=event.data.substr(8);
                        else if(event.data.substr(0,2)=='re')//服务器发送的是复活道具数目
                            re_prop=event.data.substr(7);
                        else if(event.data.substr(0,2)=='ca')//服务器发送的是货币数目
                                cash=event.data.substr(4);
                        else if(event.data.substr(0,2)=='no')//没有此用户名
                            alert("fail to login,fail to find this user_name");
                        
                        if(re_prop&&cash&&acc_prop)
                            {
                                cc.log("try to close websocket");
                                websocket.close();//主动关闭连接，所需要的信息（用户名，道具和货币数目）已经获取到了
                                cc.director.loadScene("lobby");
                            }
                    };
    
                    //报错时执行
                    websocket.onerror = function(event) {
                        console.log("error");
                        alert("fail to connect server,please open server first!");
                    };
    
                    }
                else{
                    alert("浏览器不支持WebSocket！");
                }
            }

});
