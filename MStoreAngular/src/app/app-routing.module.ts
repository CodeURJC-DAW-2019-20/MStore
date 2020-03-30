import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './helpers/auth.guard';
import { RoleGuard } from './helpers/role.guard';
import { ShopComponent } from './components/shop/shop.component';
import { PostComponent } from './components/post/post.component';
import { CartComponent } from './components/cart/cart.component';
import { ProfileComponent } from './components/public-profile/profile.component';
import { MyProfileComponent } from './components/public-profile/my-profile.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { CreatePostComponent } from './components/create-post/create-post.component';
import { IndexComponent } from './components/index/index.component';
import { ErrorComponentNF } from './components/error/errorNF.component';
import { LoginComponent } from './components/login/login.component';
import { StepperComponent } from './components/stepper/stepper.component';
import { CompleteComponent } from './components/complete/complete.component';
import { AdminComponent } from './components/admin/admin.component';
import { ErrorComponent500 } from './components/error/error500.component';
import { ErrorComponent403 } from './components/error/error403.component';

const routes: Routes = [
  { path: 'post/:id', component: PostComponent, },
  { path: 'shop', component: ShopComponent, },
  { path: 'cart', component: CartComponent, },
  { path: 'public_profile/:id', component: ProfileComponent},
  { path: 'public_profile', component: MyProfileComponent, canActivate: [AuthGuard]  },
  { path: 'edit_profile', component: EditProfileComponent, canActivate: [AuthGuard] },
  { path: 'sell_product', component: CreatePostComponent, canActivate: [AuthGuard] },
  { path: 'sign', component: LoginComponent},
  { path: '', component: IndexComponent, },
  { path: 'complete_purchase', component: StepperComponent, canActivate: [AuthGuard] },
  { path: 'complete', component: CompleteComponent, canActivate: [AuthGuard] },
  { path: 'admin', component: AdminComponent, canActivate: [RoleGuard] },
  { path: '', redirectTo: '', pathMatch: 'full' },
  {path: 'error-500', component: ErrorComponent500},
  {path: 'error-404', component: ErrorComponentNF},
  {path: 'error-403', component: ErrorComponent403},
  {path: '**', redirectTo: '/error-404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);