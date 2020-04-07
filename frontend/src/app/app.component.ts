import { Component } from '@angular/core';
import { CartService } from './services/cart.service';
import { Post } from './models/post.model';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ShopComponent } from './components/shop/shop.component';
import { Router } from '@angular/router';
import { CommunicationService } from './services/communication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  total = 0;
  cart: Post[] = [];
  idBrand: number = -1;
  idTag: number = -1;
  component: ShopComponent;

  //Despliegue del carrito
  opened = false;
  fixed = true;

  constructor(private cartService: CartService, 
    private authenticationService: AuthenticationService, 
    private communicationService: CommunicationService, 
    private router: Router) {

      communicationService.changeEmitted$.subscribe(
        filterPosts => this.changePosts(filterPosts)
      );

  }

  ngOnInit() {
    this.cartService.getCartO().subscribe(
      cart => {
        this.cart = cart;
      },
      error => console.log(error),
    );
    this.total = this.cartService.getTotal();
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

  onDelete(i: number) {
    //Este metodo aun falla cuando se llama al remove de cartService
    //cuando se coge el post es undefined pero el cart tiene el post
    this.cartService.removeFromCartIndex(i);
    this.cart = this.cartService.getCart();
    this.total = this.cartService.getTotal();
    //Para recargar cart en caso de que se este en la misma pagina
    if (this.router.url === '/cart') {
      location.reload();
    }
  }

  onActivate(component: any) {
    this.component = component;
    if (this.component instanceof ShopComponent) {
      if (this.idTag !== -1) {
        component.changeCriteriaPost(this.idTag, 'id', 'asc');
      } else if (this.idBrand !== -1) {
        component.setBrand(this.idBrand);
      } else {
        component.getAllPosts();
      }
    }
  }

  onDeactivate(component: any) {
    this.component = null;
    if (component instanceof ShopComponent) {
      this.idTag = -1;
      this.idBrand = -1;
    }
  }

  changePosts(searchPosts: any) {
    if (searchPosts.search === 'brand') {
      this.idBrand = searchPosts.id;
      if (this.component instanceof ShopComponent) {
        this.component.setBrand(searchPosts.id)
      } else {
        this.router.navigate(['/shop']);
      }
    } else if (searchPosts.search === 'tag') {
      this.idTag = searchPosts.id;
      if (this.component instanceof ShopComponent) {
        this.component.changeCriteriaPost(searchPosts.id, 'id', 'asc');
      } else {
        this.router.navigate(['/shop']);
      }
    }
  }

}