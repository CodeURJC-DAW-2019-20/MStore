import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { postComponent } from './app.postComponent';
import { shopComponent } from './app.shopComponent';
import { cartComponent } from './app.cartComponent';
import { profileComponent } from './app.profileComponent';
import { editProfileComponent } from './app.editProfileComponent';
import { createPostComponent } from './app.createPostComponent'

const routes: Routes = [
  { path: 'post/:id', component: postComponent, },
  { path: 'shop', component: shopComponent, },
  { path: 'cart', component: cartComponent, },
  { path: 'public_profile', component: profileComponent, },
  { path: 'edit_profile', component: editProfileComponent, },
  { path: 'sell_product', component: createPostComponent, },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);