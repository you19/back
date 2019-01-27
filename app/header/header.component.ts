import { Component, OnInit } from '@angular/core';
import {Utilisateur} from '../../model/model.utilisateur';
import {UtilisateurServices} from '../../services/utilisateur.services';
import {Router} from '@angular/router';
import {GroupeServices} from '../../services/groupe.services';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  utilisateur:Utilisateur;
  constructor(public groupeServices:GroupeServices,public router:Router,public utilisateurService:UtilisateurServices) { }

  ngOnInit() {
    this.utilisateur=this.utilisateurService.getUserActiv();
    //console.log("utilisateur********************* "+this.utilisateur.nom);
  }

  logout(){
    this.utilisateurService.logout();
    this.router.navigate(['login']);
  }

}
