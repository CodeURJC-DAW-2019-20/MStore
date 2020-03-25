import { NgModule } from '@angular/core';

import { FeatherModule } from 'angular-feather';
import { Mail, Unlock } from 'angular-feather/icons';

const icons = {
  Mail,
  Unlock
};

@NgModule({
  imports: [
    FeatherModule.pick(icons)
  ],
  exports: [
    FeatherModule
  ]
})
export class IconsModule { }