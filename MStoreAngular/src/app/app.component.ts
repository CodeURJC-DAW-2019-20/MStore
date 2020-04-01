import { Component, NgZone, ViewChild } from '@angular/core';
import { CartService } from './services/cart.service';
import { Post } from './models/post.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ShopComponent } from './components/shop/shop.component';
import { BrandService } from './services/brand.service';
import { Brand } from './models/brand.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MStoreAngular';
  total = 0;
  cart : Post[]=[]
  length: number;
  src:string = "./assets/img/sanchis.png"
  testVariable: string;
  @ViewChild(ShopComponent) 
  child:ShopComponent;
  brands: Brand[];
  idbrand: number=-1;
  inShop: boolean;
  component:ShopComponent;
  
  constructor(private cartService: CartService, private authenticationService: AuthenticationService, private brandService: BrandService, private Router:Router) {
  }

  ngOnInit(){
    this.cartService.getCartO().subscribe(
      cart => {
          this.cart=cart;
        },
      error => console.log(error),
    );
    this.total= this.cartService.getTotal();
    this.getBrand();
  }

  logOut() {
    this.authenticationService.logout();
  }

  Update(cart:Post[]){
    this.cart = this.cartService.getCart();
    this.total =this.cartService.getTotal();
  }

  UpdateAdd(post:Post){
    this.cart = this.cartService.getCart();
    this.total =this.cartService.getTotal();
  }

  getBrand(){
  this.brandService.getBrands().subscribe(
    response => {
      this.brands = response;
    },
    error => console.log(error)
  );
  }
  onActivate(ShopComponent) {
    this.component=ShopComponent;
    if (this.idbrand!==-1){
    ShopComponent.setBrand(this.idbrand);

  }
  else {
    ShopComponent.getAllPosts();
  }
  }

  onDeactivate(ShopComponent) {
    this.component=null;
  }

  changeItem(id:number){
    this.idbrand=id;
    if (this.component instanceof ShopComponent){
    this.component.setBrand(id);
  }
  else {
    this.Router.navigate(['/shop']);
  }
  }

}