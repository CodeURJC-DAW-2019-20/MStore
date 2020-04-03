import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-complete',
  templateUrl: './complete.component.html',
  styleUrls: ['./complete.component.css']
})
export class CompleteComponent implements OnInit {

  constructor(private authService: AuthenticationService) { }

  name: string;

  ngOnInit(): void {
    if (this.authService.isUserLog()) {
      this.name = this.authService.currentUserValue.firstName;
    }
  }

}
