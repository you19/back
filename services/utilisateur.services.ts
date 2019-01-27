import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers} from '@angular/http';
import {Utilisateur} from '../model/model.utilisateur';
import {Observable} from 'rxjs/observable';
import 'rxjs/add/observable/throw'

@Injectable()
export class UtilisateurServices{
  private isLoggedIn:boolean;
  private userActiv:Utilisateur;
  private headers = new Headers({'Content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(public http:Http){}

  public saveUtilisateur(utilisateur:Utilisateur){
    return this.http.post("http://localhost:8080/users/save",utilisateur)
      .map(resp=>resp.json());
  }

  public getUtilisateur(id:string){
    return this.http.get("http://localhost:8080/users/user/"+id)
      .map(resp=>resp.json());
  }

  public utilisateurs(){
    return this.http.get("http://localhost:8080/users/list")
      .map(resp=>resp.json());
  }

  public deleteUtilisateur(id:string){
    return this.http.delete("http://localhost:8080/users/delete/"+id)
      .map(resp=>resp.json());
  }

  public login(utilisateur:Utilisateur){
    return this.http.post("http://localhost:8080/login",utilisateur)
      .map(resp=>resp.json());
  }

  setLoggedInTrue(){
    this.isLoggedIn = true;
  }
  setIsLoggedInFalse(){
    this.isLoggedIn = false;
  }
  getIsLoggedIn(){
    return this.isLoggedIn;
  }
  setUserActiv(u:Utilisateur){
    sessionStorage.setItem("userActiv",JSON.stringify(u));
    this.userActiv = u;
  }

  logout(){
    sessionStorage.removeItem("userActiv");
  }

  static getUserActiv(){
    return JSON.parse(sessionStorage.getItem("userActiv"));
  }
  getUserActiv(){
    return JSON.parse(sessionStorage.getItem("userActiv"));
  }
  errorHandler(error:Response){
    return Observable.throw(error);
  }
}
