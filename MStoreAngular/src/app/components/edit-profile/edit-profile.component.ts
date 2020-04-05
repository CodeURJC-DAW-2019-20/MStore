import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ImageService } from 'src/app/services/image.service';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/models/user.model';


@Component({
  templateUrl: './edit-profile.component.html',
  styleUrls: []
})
export class EditProfileComponent {

  user: User;
  userLog: User;
  confirmPass: string;
  src: string;
  file: File;
  submitted: boolean = false;

  constructor(private userService: UserService, private loggedUserService: AuthenticationService,
    private imageService: ImageService, private router: Router) {
    this.getUser(this.loggedUserService.currentUserValue.id);
    this.user = {
      id: 0, firstName: '', lastName: '',
      email: '', phone: undefined, password: '', roles: [],
      userAddress: '', creditCard: undefined
    }
    this.confirmPass = '';
    this.file = undefined;
  }

  onFileChanged(event) {
    this.file = event.target.files[0];
  }

  getUser(id: number) {
    this.userService.getUser(id).subscribe(
      user => {
        this.userLog = user;
        this.user = this.userLog;
        this.user.password = "";
      },
      error => console.log(error)
    );
    this.src = "https://mdbootstrap.com/img/Others/documentation/img%20(75)-mini.jpg";
  }

  notvalid() {
    return (this.user.firstName == '' || this.user.lastName == '' || this.checkPhone() || this.user.password != this.confirmPass);
  }

  checkPhone() {
    return <any>this.user.phone == '';
  }

  checkPass() {
    return this.user.password != this.confirmPass;
  }

  logOut() {
    this.loggedUserService.logout();
  }

  onSubmit() {
    // upload code goes here
    if (this.notvalid()) {
      this.submitted = true;
    } else {
      this.userService.updateUser(this.user, this.user.id).subscribe(
        _ => {
          if (this.user.password !== '' && this.loggedUserService.logout()) {
            this.loggedUserService.login(this.user.email, this.user.password).subscribe(
              _ => { 
                this.user = undefined;
                if (confirm("User updated successfully")) {
                  this.router.navigate(['']).then(_ =>
                    window.location.reload()
                  );
                }
              },
              error => console.log(error)
            );
          }else{
            this.router.navigate(['']);
          }
        },
        error => console.log(error)
      );
      if (this.file != undefined) {
        const data = new FormData();
        data.append("imagenFile", this.file);
        this.imageService.updateUserImage(this.user.id, data).subscribe(
          _ => this.file = undefined,
          error => console.log(error)
        );
      }
    }
  }
}
