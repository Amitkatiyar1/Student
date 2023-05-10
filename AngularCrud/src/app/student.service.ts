import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { User } from './user';
import { Ufile } from './ufile';



@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURL="http://localhost:8080/get";
  private baseURL1="http://localhost:8080/add";
  private baseURL2="http://localhost:8080/delete";
  private baseURL3="http://localhost:8080/upadate";
  private baseURL4="http://localhost:8080/save";
  private baseURL5="http://localhost:8080/login";
  private baseURL6="http://localhost:8080/addFile"

  //weather
  private baseUrl7 = "http://localhost:8080/JSon";
  private baseUrl = "http://localhost:8080/g?";
  private baseUrl1 = "http://localhost:8080/";

 postUserData(user:Ufile ,file:Blob){

  let formData= new FormData();
  formData.append("file",file);
  formData.append("userData",JSON.stringify(user))
 return this.httpClient.post(`${this.baseUrl7}`,formData);

 }

  getUsers(searchKeyWord:String=""): Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}`+"name="+searchKeyWord);
  }
  getWeather(){
    return this.httpClient.get<any>(`${this.baseUrl1}`);
  }


upadateData:any;

  constructor(private httpClient:HttpClient) { }

  getStudentList():Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  
  createStudent(student:Student):Observable<Object>{
    return this.httpClient.post(`${this.baseURL1}`,student);
  }


  deleteStude(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL2}/${id}`);
  }
  updateStudent(student:Student,id:any):Observable<Object>{
    return this.httpClient.post(`${this.baseURL3}/${id}`,student);
  }

  registrationStudent(data:any):Observable<Object>{
    return this.httpClient.post(`${this.baseURL4}`,data);
    
  }
  userLogin(data:any):Observable<Object>{
    return this.httpClient.post(`${this.baseURL5}`,data);
  }

  uploadFile(file: File) :Observable<HttpEvent<any>> {

     const formData = new FormData();
    
     formData.append('file', file);
    
     return this.httpClient.post<any>(`${this.baseURL6}`, formData, {
      responseType: 'json',
      reportProgress: true,
     });
    
     }

     getFiles()
     {
      return this.httpClient.get("http://localhost:8080/getFile");
     }
     delete(fileName:any):Observable<object>{
      return this.httpClient.delete(`http://localhost:8080/del/${fileName}`);

     }


}


