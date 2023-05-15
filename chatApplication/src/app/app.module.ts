import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WebSocketApiComponent } from './web-socket-api/web-socket-api.component';
import { FormsModule } from '@angular/forms';
import { WebSocketComponent } from './web-socket/web-socket.component';



@NgModule({
  declarations: [
    AppComponent,
    WebSocketApiComponent,
    WebSocketComponent,
  
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
