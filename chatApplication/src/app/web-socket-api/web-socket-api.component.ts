import { Component, OnDestroy, OnInit } from '@angular/core';
import { WebService } from '../web.service';
import { NgForm } from '@angular/forms';
import { ChatMessage } from '../chat-message';

@Component({
  selector: 'app-web-socket-api',
  templateUrl: './web-socket-api.component.html',
  styleUrls: ['./web-socket-api.component.css']
})
export class WebSocketApiComponent implements OnInit {

  constructor(public webSocketService: WebService) { }
 

  ngOnInit(): void {
    this.webSocketService.openWebSocket();
  }

  ngOnDestroy(): void {
    this.webSocketService.closeWebSocket();
  }

  sendMessage(sendForm: NgForm) {
    const message = `Message generated at ${new Date()}`;
    const chatMessageDto = new ChatMessage(sendForm.value.user, sendForm.value.message);
    this.webSocketService.sendMessage(chatMessageDto);
    sendForm.controls['message'].reset();
  }


  
}
