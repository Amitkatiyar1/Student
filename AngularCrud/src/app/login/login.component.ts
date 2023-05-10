import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Userlogin } from '../userlogin';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

loginForm !:FormGroup;
user:Userlogin = new Userlogin();
constructor(private router :Router,private formBuilder:FormBuilder,private studentService:StudentService){

}

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      "email":[''],
      "password":['']
    })
    

  }
  login(){
    
    this.user.email=this.loginForm.value.email
    this.user.password=this.loginForm.value.password

    this.studentService.userLogin(this.user).subscribe(res=>{
      console.log(res);
      alert( "Sign in Sucessfully")
       this.sign();
    })
   
  }
  sign(){
    this.router.navigate([`/students`]);
   }
  
}
