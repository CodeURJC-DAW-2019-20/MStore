import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { shopComponent } from './app.shopComponent';
import { cartComponent } from './cart/app.cartComponent';
import { profileComponent } from './publicProfile/app.profileComponent';
import { MyProfileComponent } from './publicProfile/app.MyProfileComponent';
import { editProfileComponent } from './editProfile/app.editProfileComponent';
import { createPostComponent } from './createPost/app.createPostComponent';
import { indexComponent } from './index/app.indexComponent';
import { errorComponentNF } from './error/app.errorComponentNF';
import { LoginComponent } from './login/login.component';
import { postComponent } from './app.postComponent';
import { StepperComponent } from './stepper/stepper.component';
import { CompleteComponent } from './complete/complete.component';

const routes: Routes = [
  { path: 'post/:id', component: postComponent, },
  { path: 'shop', component: shopComponent, },
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