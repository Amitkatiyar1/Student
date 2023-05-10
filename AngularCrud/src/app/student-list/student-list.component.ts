import { Component ,OnInit} from '@angular/core';
import{Student} from '../student'
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
import { createApplication } from '@angular/platform-browser';
import { CreateStudentComponent } from '../create-student/create-student.component';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit{

  students:Student[];
  p: any=1;
  count: any=4 ;
  constructor(private pb :FormBuilder, private studentService:StudentService,private router :Router){}

  ngOnInit(): void {
    
this.getStudent();
  }
  private getStudent(){
    this.count;
    this.p;
    this.studentService.getStudentList().subscribe(data=>{
      this.students=data;
    })
  }
  updateStudent(data:any){
   this.studentService.upadateData=data
    
   this.router.navigate(['/update',])

  }
  deleteStudent(fileId:number){
    this.studentService.deleteStude(fileId).subscribe(data=>{
      this.getStudent();
      alert("delete Succesfully");
    
    })

  }

  
  
}
