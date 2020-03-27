import { NgModule } from '@angular/core';

import { FeatherModule } from 'angular-feather';
import { Mail, Unlock, ChevronsLeft, ChevronsRight, ShoppingCart, CheckCircle, Home,
  Trash2 } from 'angular-feather/icons';

const icons = {
  Mail,
  Unlock,
  ChevronsLeft,
  ShoppingCart,
  CheckCircle,
  ChevronsRight,
  Home,
  Trash2
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