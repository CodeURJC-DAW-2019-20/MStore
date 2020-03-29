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
  submitted: boolean = false;
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
    this.user = {
      id: 1, firstName: '', lastName: '',
      email: '', password: '', roles: ['ROLE_USER']
    };
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  onSubmit(username: string, password: string) {
    this.submitted = true;

    this.authenticationService.login(username, password)
      .pipe(first())
      .subscribe(
        _ => {
          this.router.navigate([this.returnUrl]);
        },
        error => console.log(error)
      );
  }

  onSignUp(confirmPassword: string) {
    if (this.user.password === confirmPassword) {
      this.userService.addUser(this.user).subscribe(
        _ => this.user = undefined,
        error => console.log(error)
      );
    } else {
      console.log('No es valido');
    }
    if (confirm('Registration successful')) {
      this.onSubmit(this.user.email, this.user.password);
    }
  }

}
