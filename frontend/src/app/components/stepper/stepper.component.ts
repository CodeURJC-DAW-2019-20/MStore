import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import Stepper from 'bs-stepper';

@Component({
  selector: 'app-stepper',
  templateUrl: './stepper.component.html',
  styleUrls: ['./stepper.component.css']
})
export class StepperComponent implements OnInit {

  private stepper: Stepper;
  user: User;
  step3: boolean; 

  next(user: User) {
    this.user = user;
    this.stepper.next();
    this.step3 = true;
  }

  previous() {
    this.stepper.previous();
    this.step3 = false;
  }

  constructor() { 
    this.step3 = false;
  }

  ngOnInit(): void {
    this.stepper = new Stepper(document.querySelector('#stepper1'), {
      linear: true,
      animation: true
    })
    this.stepper.to(2);
  }

}
