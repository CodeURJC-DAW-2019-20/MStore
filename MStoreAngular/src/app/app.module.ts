import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ShopComponent } from './components/shop/shop.component';
import { PostComponent } from './components/post/post.component';
import { cartComponent } from './components/cart/app.cartComponent';
import { profileComponent } from './components/publicProfile/app.profileComponent';
import { MyProfileComponent } from './components/publicProfile/app.MyProfileComponent';
import { editProfileComponent } from './components/editProfile/app.editProfileComponent';
import { createPostComponent } from './components/createPost/app.createPostComponent';
import { indexComponent } from './components/index/app.indexComponent';
import { errorInterceptor } from './components/error/app.errorInterceptor';
import { errorComponentNF } from './components/error/app.errorComponentNF';
import { LoginComponent } from './components/login/login.component';
import { IconsModule } from './components/icons/icons.module';
import {ShowPostsComponent} from './components/showPosts/app.showPostsComponent';
import { PaymentComponent } from './components/payment/payment.component';
import { StepperComponent } from './components/stepper/stepper.component';
import { FinalReviewComponent } from './components/final-review/final-review.component';
import { CompleteComponent } from './components/complete/complete.component';

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    PostComponent,
    cartComponent,
    profileComponent,
    MyProfileComponent,
    editProfileComponent,
    createPostComponent,
    indexComponent,
    errorComponentNF,
    LoginComponent,
    ShowPostsComponent,
    PaymentComponent,
    StepperComponent,
    FinalReviewComponent,
    CompleteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    IconsModule
  ],
  providers: [      
    {provide: HTTP_INTERCEPTORS,
    useClass: errorInterceptor,
    multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
