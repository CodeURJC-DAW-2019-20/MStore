import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { postComponent } from './app.postComponent';
import { shopComponent } from './app.shopComponent';
import { cartComponent } from './app.cartComponent';
import { profileComponent } from './app.profileComponent';
import { editProfileComponent } from './app.editProfileComponent';

const routes: Routes = [
  { path: 'post/:id', component: postComponent, },
  { path: 'shop', component: shopComponent, },
  { path: 'cart', component: cartComponent, },
  { path: 'profile', component: profileComponent, },
  { path: 'edit_profile', component: editProfileComponent, }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);