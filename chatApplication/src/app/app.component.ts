import { Component, OnInit } from '@angular/core';
import { Web } from './web';
import { NgForm } from '@angular/forms';
import { ChatMessage } from './chat-message';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
 
  web !: Web;
  greeting: any;
  name: string | undefined;

  chatMessages: ChatMessage[] = [];
  
  ngOnInit(): void {
    this.web = new Web(new AppComponent());
  }

  
    connect(){
      //this.web._connect();
      this.web.connect();
    }
  
    disconnect(){
      this.web._disconnect();
    }
  
    sendMessage(sendForm: NgForm){
   //   this.web._send(this.name);
     const chatMessageDto = new ChatMessage(sendForm.value.user, sendForm.value.message);
      this.web.send(chatMessageDto);
      sendForm.controls['message'].reset();
    }
  
    handleMessage(message: any){
      this.greeting = message;
      this.chatMessages =message=[];   
    }
    
  
}
