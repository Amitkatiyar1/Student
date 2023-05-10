
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent  implements OnInit{

  user:User = new User();
  signUpForm !:FormGroup;
constructor(private formbuilder :FormBuilder, private studentService :StudentService,private router :Router){


}
  ngOnInit(): void {
   
this.signUpForm = this.formbuilder.group({
name:[''],
email:['',Validators.required],
password:['',Validators.required],
id:['',Validators.required]

})

  }
    signUp(){

  this.user.name=this.signUpForm.value.name
  this.user.email=this.signUpForm.value.email
  this.user.id=this.signUpForm.value.id
  this.user.password=this.signUpForm.value.user

      this.studentService.registrationStudent(this.user).subscribe(data=>{
      console.log(data);
      alert("registered Sucessfully!!");
       this.sign();
        })
}

sign(){
  this.router.navigate([`/login`]);
 }
  


}
