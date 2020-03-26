import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { shopComponent } from './app.shopComponent';
import { postComponent } from './app.postComponent';
import { cartComponent } from './cart/app.cartComponent';
import { profileComponent } from './publicProfile/app.profileComponent';
import { MyProfileComponent } from './publicProfile/app.MyProfileComponent';
import { editProfileComponent } from './editProfile/app.editProfileComponent';
import { createPostComponent } from './createPost/app.createPostComponent';
import { indexComponent } from './index/app.indexComponent';
import { errorInterceptor } from './error/app.errorInterceptor';
import { errorComponentNF } from './error/app.errorComponentNF';
import { LoginComponent } from './login/login.component';
import { IconsModule } from './icons/icons.module';
import {ShowPostsComponent} from './showPosts/app.showPostsComponent';
import { PaymentComponent } from './payment/payment.component';
import { StepperComponent } from './stepper/stepper.component';
import { FinalReviewComponent } from './final-review/final-review.component';
import { CompleteComponent } from './complete/complete.component';

@NgModule({
  declarations: [
    AppComponent,
    postComponent,
    shopComponent,
    cartComponent,
    profileComponent,
    MyProfileComponent,
    editProfileComponent,
    createPostComponent,
    indexComponent,
    errorComponentNF,
    indexComponent,
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
