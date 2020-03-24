import { Component } from '@angular/core';

interface User{
  firstName:string;
  lastName:string;
  email:string;
  userAddress?:string;
  password:string;
  phone:number;
  creditCard?:number;
}

@Component({
  templateUrl: './app.editProfileComponent.html',
  styleUrls: []
})
export class editProfileComponent {

  user:User;
  confirmPass:string;

  constructor() {
   this.user = {firstName:'Diego',lastName:'Montoto',email:'dm@gmail.com', password:"hola",phone:654432987};
  }

}
