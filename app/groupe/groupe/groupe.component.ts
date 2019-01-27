import { Component, OnInit } from '@angular/core';
import {GroupeServices} from '../../../services/groupe.services';
import {Groupe} from '../../../model/model.groupe';
import {Utilisateur} from '../../../model/model.utilisateur';
import {UtilisateurServices} from '../../../services/utilisateur.services';
import {Router} from '@angular/router';

@Component({
  selector: 'app-groupe',
  templateUrl: './groupe.component.html',
  styleUrls: ['./groupe.component.css']
})
export class GroupeComponent implements OnInit {

  utilisateur:Utilisateur;
  groupes:Array<any>=new Array(Groupe);

  constructor(public groupeServices:GroupeServices,public router:Router,public utilisateurService:UtilisateurServices) { }

  ngOnInit() {
    this.utilisateur=this.utilisateurService.getUserActiv();

    if(this.utilisateur!=null){
      if(this.utilisateur.id=="admin"){
        console.log("je suis l'admin dyal zbel kamel");
      }else{
        console.log("ana ma admin ma walo 3tiwni tissa3");
      }
      console.log("je suis "+this.utilisateurService.getUserActiv().nom);
    }else {
      console.log("utilisateur null");
    }
    this.groupeServices.groupes()
      .subscribe(data=>{
        console.log(data);
        this.groupes=data;
      },err=>{
        console.log(err);
      })
  }



}
