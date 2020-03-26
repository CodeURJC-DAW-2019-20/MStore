import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  @Output()
  next1 = new EventEmitter();

  cart=[{id: 1, name: 'AMD card', price:80,  description: 'new AMD card'},
  {id: 2, name: 'AMD card 2', price:220,  description: 'new AMD card'},
  {id: 3, name: 'AMD card 3', price:50,  description: 'new AMD card'}];
  total=350;

  constructor() { }

  ngOnInit(): void {
  }

  next() {
    this.next1.emit();
  }

}
