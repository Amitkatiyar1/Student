import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent  {

  selectedFiles?: FileList;

   currentFile?: File;
   previews: string[] = [];
   fileInfo?: Observable<any>;
   count:any=4;
   p:any=2;
  
   constructor(private uploadService: StudentService) {
  
    this.fileInfo = this.uploadService.getFiles();
    console.log(this.fileInfo);
  }
 

   selectFile(event: any): void {
  
    this.selectedFiles = event.target.files;
    this.previews = [];
  if (this.selectedFiles && this.selectedFiles[0]) {
    const numberOfFiles = this.selectedFiles.length;
    for (let i = 0; i < numberOfFiles; i++) {
      const reader = new FileReader();

      reader.onload = (e: any) => {
        console.log(e.target.result);
        this.previews.push(e.target.result);
      };

      reader.readAsDataURL(this.selectedFiles[i]);
    }
  }
  
   }
  
   upload(): void {
  
    if (this.selectedFiles) {
  
     const file: File | null = this.selectedFiles.item(0);
  
     if (file) {
  
      this.currentFile = file;
  
      this.uploadService.uploadFile(this.currentFile).subscribe({
  
      next: (event: any) => {
  
         this.fileInfo = this.uploadService.getFiles();
  
       },
  
      });
  
     }

     this.selectedFiles = undefined;
     this.currentFile = undefined;
    }
  
   }
  
delete(fileName:any){
  this.uploadService.delete(fileName).subscribe(data=>{

    alert("delete Succesfully");
    
  })
}
 
}

 //  url = undefined;
  //  selectFile(event:any) {
  //    if (event.target.files && event.target.files[0]) {
  //      var reader = new FileReader();
 
  //      reader.readAsDataURL(event.target.files[0]); // read file as data url
 
  //      reader.onload = (event) => { // called once readAsDataURL is completed
  //        this.url = event.target.result;
  //      }
  //    }
  //  }

 //   if (event.type === HttpEventType.UploadProgress) {
  
      //  //  Math.round(100 * event.loaded / event.total);
  
      //   } else if (event instanceof HttpResponse) {
  
      //    this.message = event.body.message;

        //  error: (err: any) => {
  
      //   console.log(err);
  
      //   if (err.error && err.error.message) {
  
      //    this.message = err.error.message;
  
      //   } else {
  
      //    this.message = 'Could not upload the file!';
  
      //   }
  
  
      //   this.currentFile = undefined;
  
      //  }
  