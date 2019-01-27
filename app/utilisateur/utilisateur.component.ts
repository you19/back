import { Component, OnInit } from '@angular/core';
import "rxjs/add/operator/map";
import {UtilisateurServices} from '../../services/utilisateur.services';
import {Router} from '@angular/router';
import {Utilisateur} from '../../model/model.utilisateur';
import { GroupeServices } from '../../services/groupe.services';
import { Groupe } from '../../model/model.groupe';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {
  utilisateur:Utilisateur = new Utilisateur();
  groupes:Array<any>=new Array(Groupe);
  constructor(public utilisateurServices:UtilisateurServices,public groupeServices:GroupeServices,router:Router) { }

  ngOnInit() {
    this.groupeServices.groupes()
      .subscribe(data=>{
        console.log(data);
        this.groupes=data;
      },err=>{
        console.log(err);
      })
  }

  saveUtilisateur(){
    this.utilisateurServices.saveUtilisateur(this.utilisateur)
      .subscribe(data=>{
        this.utilisateur=data;
        console.log(data);
      },err=>{
        console.log(err);
      })
  }

}
