import { Component ,OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router} from '@angular/router';
import { FormBuilder, FormGroup ,Validators} from '@angular/forms';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit{
  formvalue !: FormGroup;
  student: Student = new Student();

  constructor(private formbuilder:FormBuilder,private studentService:StudentService ,private router:Router){}

  ngOnInit(): void {
    this.formvalue= this.formbuilder.group({
      id:['',Validators.required],
        name:['',Validators.required],
        address:['',Validators.required],
        post:['',Validators.required],
        age:['',Validators.required],
        
    })
  }

  private addStudent(){
    this.student.name=this.formvalue.value.name;
    this.student.age=this.formvalue.value.age;
    this.student.post=this.formvalue.value.post;
    this.student.id=this.formvalue.value.id;
    this.student.address=this.formvalue.value.address;
    this.studentService.createStudent(this.student).subscribe(data=>{
console.log(data);
this.Save();
alert("add Suceesfully");

    })
    
    // error=>console.log(error);
  }
 
  Save(){
   this.router.navigate([`/login`]);
  }

  onSubmit(){
    console.log(this.student);
this.addStudent();
  }







//   EditStudent(student:Student){
//     this.student.id=student.id;
// this.formvalue.controls['name'].setValue(student.name);
// this.formvalue.controls['age'].setValue(student.age);
// this.formvalue.controls['address'].setValue(student.address);
// this.formvalue.controls['post'].setValue(student.post);
// this.formvalue.controls['id'].setValue(student.id);
//   }

  // updateStudent( id:any,student:Student){
  //   this.student.name=this.formvalue.value.name;
  //   this.student.age=this.formvalue.value.age;
  //   this.student.post=this.formvalue.value.post;
  //   this.student.id=this.formvalue.value.id;
  //   this.student.address=this.formvalue.value.address;

  // }
}
