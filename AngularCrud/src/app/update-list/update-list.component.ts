import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-update-list',
  templateUrl: './update-list.component.html',
  styleUrls: ['./update-list.component.css']
})
export class UpdateListComponent{

  data:any;
  constructor(private router :Router,private formbuilder:FormBuilder,private studentService:StudentService){
    this.data=this.studentService.upadateData;

console.log(this.data);

this.formvalue.setValue(this.data);


  }
formvalue= new FormGroup({
      id: new FormControl(),
        name: new FormControl(),
        address: new FormControl(),
        post: new FormControl(),
        age: new FormControl(),
})

updateForm(){
  
  this.studentService.updateStudent(this.formvalue.value.id, this.formvalue.value).subscribe(res=>{
    
console.log(res)
     this.router.navigate(['/students'])
  })
}




  }