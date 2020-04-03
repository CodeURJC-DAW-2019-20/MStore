import { Component, NgZone, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { User } from 'src/app/models/user.model';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output()
  show = new EventEmitter();

  @Input()
  length: number;

  @Input()
  total: number;

  user: User;
  isLogged: boolean;
  isAdmin: boolean;

  constructor(private cartService: CartService, private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.isLogged = this.authenticationService.isUserLog();
    if (this.isLogged) {
      this.user = this.authenticationService.currentUserValue;
      this.isAdmin = this.user.roles.includes("ROLE_ADMIN");
    }
  }

  logOut() {
    this.authenticationService.logout();
    location.reload();
  }

  openCart() {
    this.show.emit();
  }

}