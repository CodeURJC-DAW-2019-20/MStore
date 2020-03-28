import { Component } from '@angular/core';
import * as CanvasJS from './canvasjs.min';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { GraphicsService } from 'src/app/services/graphics.service';
import { LoggedUserService } from 'src/app/services/loggedUser.service';
import {User} from 'src/app/models/user.model';
import {LoggedUser} from 'src/app/models/loggedUser.model';

@Component({
  templateUrl: './profile.component.html',
  styleUrls: []
})
export class ProfileComponent {

  user:User;
  loggedUser:User;
  loggedUserInfo:LoggedUser;
  id:number;
  src:string;
  chart:CanvasJS.Chart;
  chartData:number[] = [];
  canRate:boolean;

  constructor(private activatedRoute:ActivatedRoute, private userService:UserService, private graphicsService:GraphicsService, private loggedUserService:LoggedUserService) {
    this.id=activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.loggedUserInfo=this.loggedUserService.getLogguedUserInfo();
    this.getUser(this.id);
    this.getGraph(this.id);   
  }

  createGraph(data:number[]){
    this.chart = new CanvasJS.Chart("chartContainer", {
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: "Seller rating"
      },
      data: [{
        type: "column",
        dataPoints: [
          { y: data[0], label: "5 stars" },
          { y: data[1], label: "4 stars" },
          { y: data[2], label: "3 stars" },
          { y: data[3], label: "2 stars" },
          { y: data[4], label: "1 stars" },
          { y: data[5], label: "0 stars" },
        ]
      }]
    });
          
    this.chart.render();
  }

  getUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.user=user;
        if(this.loggedUserService.isUserLog())
          this.getLoggedUser(this.loggedUserInfo.id);
      },
      error => console.log(error)
    );
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  getLoggedUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.loggedUser=user;
        this.canRate= this.canUserRate(this.loggedUser.sellers);
      },
      error => console.log(error)
    );
  }

  canUserRate(sellers:Array<User>){
    for(let i=0; i<sellers.length;i++){
      if(sellers[i].id==this.user.id)
        return true;
    }
    return false;
  }

  getGraph(id:number){
    this.graphicsService.getGraphic(id).subscribe(
      graph => {
        this.chartData=graph;
        this.createGraph(this.chartData); 
      },
      error => console.log(error)
    );
  }

  updateRate(){
    this.canRate=false;
  }
}
