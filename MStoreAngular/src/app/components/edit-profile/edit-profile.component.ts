import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/models/user.model';


@Component({
  templateUrl: './edit-profile.component.html',
  styleUrls: []
})
export class EditProfileComponent {

  user:User;
  userLog:User;
  confirmPass:string;
  src:string;
  file:File;
  submitted: boolean = false;

  constructor(private userService:UserService, private loggedUserService: AuthenticationService) {
    this.getUser(this.loggedUserService.currentUserValue.id);
    this.user={id:0,firstName:'', lastName:'',
      email:'',phone:undefined,password:'',roles:[],
      userAddress:'',creditCard:undefined}
  }

  onFileChanged(event) {
    this.file = event.target.files[0];
  }

  getUser(id:number){
    this.userService.getUser(id).subscribe(
      user => {
        this.userLog = user;
        this.user={id:this.userLog.id,firstName:this.userLog.firstName, lastName:this.userLog.lastName,
              email:this.userLog.email,phone:this.userLog.phone,password:'',roles:this.userLog.roles,
              userAddress:this.userLog.userAddress,creditCard:this.userLog.creditCard};
      },
      error => console.log(error)
    );
    this.src="https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  notvalid(){
    return (this.user.firstName == '' || this.user.lastName == '' || this.checkPhone());
  }

  checkPhone(){
    return <any>this.user.phone == '';
  }

  onSubmit() {
    // upload code goes here
    if (this.notvalid()){
      this.submitted = true;
    }else{
      this.userService.updateUser(this.user,this.user.id).subscribe(
        post => console.log("hola"),
        error => console.log(error)
      );
    }
    
  }
}
