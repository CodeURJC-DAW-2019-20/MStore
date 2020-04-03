import { NgModule } from '@angular/core';

import { FeatherModule } from 'angular-feather';
import { Mail, Unlock, ChevronsLeft, ChevronsRight, ShoppingCart, CheckCircle, Home,
  Trash2, CreditCard, Search, Edit, ArrowRight, Monitor, ChevronRight, HardDrive, Video,
  Headphones, Printer, Speaker, Server, LogIn, LogOut, MoreHorizontal, User, XCircle } from 'angular-feather/icons';

const icons = {
  Mail,
  Unlock,
  ChevronsLeft,
  ShoppingCart,
  CheckCircle,
  ChevronsRight,
  Home,
  Trash2,
  CreditCard,
  Search,
  Edit,
  ArrowRight,
  Monitor,
  ChevronRight,
  HardDrive,
  Video,
  Headphones,
  Printer,
  Speaker,
  Server,
  LogOut,
  LogIn,
  MoreHorizontal,
  User,
  XCircle
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