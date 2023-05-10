import { Component } from '@angular/core';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent {
 
  Weather:any
 myWeather:any;
 tempature:number=0;
 humidity:any;
 pressure:any;
feelsLikeTem:number=0;
summary:string='';
iconUrl:string='';
name:string='';
 date:any

  constructor(private weatherService: StudentService) { }

  ngOnInit(): void { 
    this.getCurrent();
    this.getList();
  }


  getCurrent(){
    this.weatherService.getWeather().subscribe((data:any)=>{
      this.myWeather=data;
       this.tempature= this.myWeather.temp;
       this.humidity= this.myWeather.humidity;
       this.pressure= this.myWeather.pressure;
       this.feelsLikeTem=this.myWeather.feels_like;
      this.summary= this.myWeather.main;
      this.name=this.myWeather.name;
      this.date=this.myWeather.date;
  
    })
   
  }

  getList(searchKeyWord:String=""){
  this.weatherService.getUsers().subscribe((data:any) => {
      
    console.log(data);
    this.Weather = data;
  });
 }

  Search(searchKeyWord:String=""){
    console.log(searchKeyWord)
    this.Weather=[];
    this.getList(searchKeyWord);
    
  
  }

}
