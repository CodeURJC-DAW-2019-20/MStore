import { Component } from '@angular/core';

interface User{
  firstName:string;
  lastName:string;
  email:string;
  phone:number;
}

@Component({
  templateUrl: './app.profileComponent.html',
  styleUrls: []
})
export class profileComponent {

  user:User;

  constructor() {
   this.user = {firstName:'Diego',lastName:'Montoto',email:'dm@gmail.com',phone:654432987};
  }

}
