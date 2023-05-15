import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { ChatMessage } from './chat-message';
@Injectable({
  providedIn: 'root'
})
export class WebService {
 

  

  webSocket !: WebSocket;
  chatMessages: ChatMessage[] = [];

  constructor() { }

  
  public openWebSocket(){
    this.webSocket = new WebSocket('ws://localhost:8080/chat');

    this.webSocket.onopen = (event) => {
      console.log('Open: ', event);
    };

    this.webSocket.onmessage = (event) => {
      const chatMessageDto = JSON.parse(event.data);
      this.chatMessages.push(chatMessageDto);
    };

    this.webSocket.onclose = (event) => {
      console.log('Close: ', event);
    };
  
  }


  errorCallBack(error: string) {
    console.log("errorCallBack -> " + error)
    setTimeout(() => {
        this.openWebSocket();
    }, 1000);
}


  public sendMessage(chatMessageDto: ChatMessage){
    this.webSocket.send(JSON.stringify(chatMessageDto));
  }

  public closeWebSocket() {
    this.webSocket.close();
  }

}
