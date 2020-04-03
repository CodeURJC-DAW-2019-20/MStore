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
  cart: Post[] = [];
  @ViewChild(ShopComponent)
  child: ShopComponent;
  brands: Brand[];
  idbrand: number = -1;
  inShop: boolean;
  component: ShopComponent;

  //Despliegue del carrito
  opened = false;
  fixed = true;

  constructor(private cartService: CartService, private authenticationService: AuthenticationService, private brandService: BrandService, private router: Router) {
  }

  ngOnInit() {
    this.cartService.getCartO().subscribe(
      cart => {
        this.cart = cart;
      },
      error => console.log(error),
    );
    this.total = this.cartService.getTotal();
    this.getBrand();
  }

  showCart() {
    this.opened = true;
    this.cart = this.cartService.getCart();
    this.total = this.cartService.getTotal();
  }

  logOut() {
    this.authenticationService.logout();
  }

  onSubmit() {
    this.opened = false;
    this.router.navigate(['/cart']);
  }

  onDelete(id: number) {
    //Este metodo aun falla cuando se llama al remove de cartService
    //cuando se coge el post es undefined pero el cart tiene el post
    this.cartService.removeFromCartIndex(id);
    this.cart = this.cartService.getCart();
    this.total = this.cartService.getTotal();
  }

  getBrand() {
    this.brandService.getBrands().subscribe(
      response => {
        this.brands = response;
      },
      error => console.log(error)
    );
  }

  onActivate(Component) {
    this.component = Component;
    if (this.component instanceof ShopComponent) {
      if (this.idbrand !== -1) {
        Component.setBrand(this.idbrand);

      }
      else {
        Component.getAllPosts();
      }
    }
  }

  onDeactivate(ShopComponent) {
    this.component = null;
  }

  changeItem(id: number) {
    this.idbrand = id;
    if (this.component instanceof ShopComponent) {
      this.component.setBrand(id);
    }
    else {
      this.router.navigate(['/shop']);
    }
  }

}