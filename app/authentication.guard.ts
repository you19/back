import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {UtilisateurServices} from '../services/utilisateur.services';

@Injectable()
export class AuthenticationGuard implements CanActivate {

  constructor(private utilisateurServices:UtilisateurServices){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return true;
  }
}
