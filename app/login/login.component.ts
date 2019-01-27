import { Component, OnInit } from '@angular/core';
import {Utilisateur} from '../../model/model.utilisateur';
import {Router} from '@angular/router';
import {UtilisateurServices} from '../../services/utilisateur.services';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  utilisateur:Utilisateur = new Utilisateur();

  constructor(public router:Router,public utilisateurServices:UtilisateurServices) { }

  ngOnInit() {
  }

  public login(){
    console.log("test1");
    this.utilisateurServices.login(this.utilisateur)
      .subscribe(data=>{
        if(data.id != null){
          console.log("data: "+data.nom);
          this.utilisateurServices.setLoggedInTrue();
          this.utilisateurServices.setUserActiv(data);
          this.utilisateur=this.utilisateurServices.getUserActiv();
          console.log("nom: "+this.utilisateur.nom);
          this.router.navigate(['projet']);
        }
      },err=>{
        alert("email ou password incorrect!!!");
        console.log(err);
      }
    )
  }

}
