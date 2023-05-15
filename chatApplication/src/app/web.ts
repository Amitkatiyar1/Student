import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { AppComponent } from './app.component';
import { ChatMessage } from './chat-message';

export class Web {
    
[x: string]: any;

    webSocketEndPoint: string = 'http://localhost:8080/startWebsocket';
    topic: string = "/topic/startWebsocket";
    
    webSocketEndPoint1: string = 'http://localhost:8080/secured/room/';
   
    stompClient: any;
    appComponent: AppComponent;

    chatMessages: ChatMessage[] = [];
  
  userName: string | undefined;
  sessionId = "";
  selectedUser: string | undefined;
  newMessages = new Map<string, string>();
    constructor(appComponent: AppComponent){
        this.appComponent = appComponent;
    }


    _connect() {
        console.log("Initialize WebSocket Connection");
        let ws = new SockJS(this.webSocketEndPoint);
        this.stompClient = Stomp.over(ws);
        const _this = this;
        _this.stompClient.connect({}, function (frame: any) {
            _this.stompClient.subscribe(_this.topic, function (sdkEvent: any) {
                _this.onMessageReceived(sdkEvent);
                
            });
            //_this.stompClient.reconnect_delay = 2000;
        }, this.errorCallBack);
    };

    connect() {
        console.log("Initialize specific WebSocket Connection");
        let ws = new SockJS(this.webSocketEndPoint1);
        var url = this.stompClient.http._transport.ws;
        this.stompClient = Stomp.over(ws);
        const _this = this;
        _this.stompClient.connect({},  (frame: any) => {
            _this.stompClient.subscribe('secured/user/queue/specific-user'  + '-user' + this.sessionId, function (sdkEvent: any) {
                _this.onMessageReceived(sdkEvent);
                url = url.replace("/websocket", "");
      url = url.replace(/^[0-9]+\//, "");
        console.log("Your current session is: " + url);
         const sessionId = url;
                // sessionId= webSocketEndPoint1
            });
           
        }, this.errorCallBack);
    };

    _disconnect() {
        if (this.stompClient !== null) {
            this.stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    
    errorCallBack(error: string) {
        console.log("errorCallBack -> " + error)
        setTimeout(() => {
            this._connect();
        }, 1000);
    }


    _send(chatMessageDto: ChatMessage) {
        console.log("calling logout api via web socket");
        this.stompClient.send("/app/hello", {}, JSON.stringify(chatMessageDto));
    }
    send(chatMessageDto: ChatMessage) {
        console.log("calling logout api via web socket");
        this.stompClient.send("app/secure", {}, JSON.stringify(chatMessageDto));
    }
    onMessageReceived(message: any) {
        console.log("Message Recieved from Server :: " + message);
       // this.appComponent.handleMessage(JSON.stringify(message.body));
        this.appComponent.handleMessage(JSON.stringify(message.body));
        this.chatMessages.push(message)
    }

    // registration() {
    //     this.http.get(this.url + "/registration/" + this.userName).subscribe(
    //       (response: any) => {
    //         this._connect(this.userName);
    //       },
    //       (error: any) => {
    //         if (error.status === 400) {
    //           alert("Login is already busy!");
    //         }
    //       }
    //     );
    //   }
    

}
