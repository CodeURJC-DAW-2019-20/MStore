import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { UserService } from 'src/app/services/user.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  users: User[] = [];
  submittedFailed: boolean = false;
  notValidEmail: boolean = false;
  notValidPass: boolean = false;
  notFound: boolean = false;
  userExists: boolean = false;
  returnUrl: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private authenticationService: AuthenticationService) {
    //Si ya esta registrado
    if (this.authenticationService.currentUserValue) {
      this.router.navigate(['/']);
    }
  }

  ngOnInit(): void {
    this.getUsers();
    this.user = {
      id: 1, firstName: '', lastName: '',
      email: '', password: '', phone: null, roles: ['ROLE_USER']
    };
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  changeEmail(email: string) {
      if (email.includes('@') && email.includes('.')) {
        this.notValidEmail = false;
      } else {
        this.notValidEmail = true;
      }
  }

  changePass(password: string) {
    if (password === '') {
      this.notValidPass = true;
    } else {
      this.notValidPass = false;
    }
  }

  onSubmit(username: string, password: string) {
    if (username === '' || password === '' || !(username.includes('@') && username.includes('.'))) {
      if (username === '' || (!username.includes('@') && !username.includes('.'))) {
        this.notValidEmail = true;
      }
      if (password === '') {
        this.notValidPass = true;
      }
      this.submittedFailed = true;
      return;
    }

    this.authenticationService.login(username, password)
      .pipe(first())
      .subscribe(
        _ => {
          window.location.reload();
          this.router.navigate([this.returnUrl]);
        },
        error => {
          console.log(error)
          this.notFound = true;
        }
      );
  }

  getUsers() {
    this.userService.getUsers().subscribe(
      users => this.users = users,
      error => console.log(error)
    );
  }

  changeConfirmPass(formGroup: any,confirmPassword: string) {
    if (this.user.password === confirmPassword && confirmPassword !== '') {
      formGroup.controls['confirmPassword'].setErrors(null);     
    } else if (confirmPassword === '') {
        formGroup.controls['confirmPassword'].setErrors({ required: true });
    } else {
      formGroup.controls['confirmPassword'].setErrors({ mustMatch: true });
    }
  }

  notvalid(confirmPassword: string){
    return (this.user.firstName === '' || this.user.lastName === '' || this.user.email === '' || 
      this.user.phone === null || this.user.password === '' || confirmPassword === '');
  }

  onSignUp(formGroup: any,confirmPassword: string) {
    if (this.notvalid(confirmPassword)) {
      return;
    } else if (this.user.password !== confirmPassword) {
      return formGroup.controls['confirmPassword'].setErrors({ mustMatch: true });
    } else if (this.users.filter(user => user.email === this.user.email).length > 0) {
      return this.userExists = true;
    }
    this.userService.addUser(this.user).subscribe(
        _ => this.user = undefined,
        error => console.log(error)
      );
    if (confirm('Registration successful')) {
      this.onSubmit(this.user.email, this.user.password);
      this.submittedFailed = false;
    }
  }
}
