import { Component, OnInit } from '@angular/core';

import { Ufile } from '../ufile';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponentComponent {
  file !: any;

  constructor(private userService:StudentService){ }
  
 user = new Ufile(0,"","","");
 onChangeFile(event:any){
  //console.log(event.target.files[0]);
  this.file= event.target.files[0];
  this.user.imageName= this.file.name;
  console.log(this.file);
 
 }
 doRegister(){
  
  this.userService.postUserData(this.user,this.file).subscribe({
    next:(response)=>{},
    complete:()=>{
      console.log("Request Completed");

    }

  })

 }
  
}
