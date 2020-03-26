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
  src:string;
  file:File;

  constructor() {
   this.user = {firstName:'Diego',lastName:'Montoto',email:'dm@gmail.com', password:"hola",phone:654432987};
   this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  onFileChanged(event) {
    this.file = event.target.files[0];
  }

  onUpload() {
    // upload code goes here
  }
}
