import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ShopComponent } from './components/shop/shop.component';
import { PostComponent } from './components/post/post.component';
import { cartComponent } from './components/cart/app.cartComponent';
import { profileComponent } from './components/publicProfile/app.profileComponent';
import { MyProfileComponent } from './components/publicProfile/app.MyProfileComponent';
import { editProfileComponent } from './components/editProfile/app.editProfileComponent';
import { createPostComponent } from './components/createPost/app.createPostComponent';
import { indexComponent } from './components/index/app.indexComponent';
import { errorComponentNF } from './components/error/app.errorComponentNF';
import { LoginComponent } from './components/login/login.component';
import { StepperComponent } from './components/stepper/stepper.component';
import { CompleteComponent } from './components/complete/complete.component';

const routes: Routes = [
  { path: 'post/:id', component: PostComponent, },
  { path: 'shop', component: ShopComponent, },
  { path: 'cart', component: cartComponent, },
  { path: 'public_profile/:id', component: profileComponent, },
  { path: 'public_profile', component: MyProfileComponent, },
  { path: 'edit_profile', component: editProfileComponent, },
  { path: 'sell_product', component: createPostComponent, },
  { path: 'sign', component: LoginComponent},
  { path: '', component: indexComponent, },
  { path: 'stepper', component: StepperComponent},
  { path: 'complete', component: CompleteComponent},
  { path: '', redirectTo: '', pathMatch: 'full' },
  {path: 'error-404', component: errorComponentNF},
  {path: '**', redirectTo: '/error-404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);