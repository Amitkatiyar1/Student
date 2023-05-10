import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentListComponent } from './student-list/student-list.component';
import { CreateStudentComponent } from './create-student/create-student.component';

import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { UpdateListComponent } from './update-list/update-list.component';
import { UploadFileComponent } from './upload-file/upload-file.component';
import { WeatherComponent } from './weather/weather.component';
import { UserComponentComponent } from './user-component/user-component.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'students', component: StudentListComponent },
  { path: 'students/create-student', component: CreateStudentComponent },
  { path: 'update', component: UpdateListComponent },
  { path: 'upload', component: UploadFileComponent },
  { path: 'weather', component: WeatherComponent },
  { path: "User", component: UserComponentComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
