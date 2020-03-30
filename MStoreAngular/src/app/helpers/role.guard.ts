import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';

import { AuthenticationService } from 'src/app/services/authentication.service';

@Injectable({ providedIn: 'root' })
export class RoleGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {}

    canActivate(route: ActivatedRouteSnapshot) {
        const currentUser = this.authenticationService.currentUserValue;
        if ( currentUser && currentUser.roles.includes('ROLE_ADMIN')) {
            // authorised so return true
            return true;
        }

        // not admin so redirect to error-403
        this.router.navigate(['/error-403']);
        return false;
    }
}