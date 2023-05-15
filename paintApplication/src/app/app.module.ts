import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DrawComponent } from './draw/draw.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { KonvaModule } from "ng2-konva";
@NgModule({
  declarations: [
    AppComponent,
    DrawComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    KonvaModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
