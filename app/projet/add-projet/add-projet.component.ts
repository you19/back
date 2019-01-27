import { Component, OnInit } from '@angular/core';
import {ProjetServices} from '../../../services/projet.services';
import {Router} from '@angular/router';
import {Projet} from '../../../model/model.projet';
import {UtilisateurServices} from '../../../services/utilisateur.services';
import {Utilisateur} from '../../../model/model.utilisateur';

@Component({
  selector: 'app-add-projet',
  templateUrl: './add-projet.component.html',
  styleUrls: ['./add-projet.component.css']
})
export class AddProjetComponent implements OnInit {
  projet:Projet = new Projet();
  prop:Utilisateur;

  constructor(public projetServices:ProjetServices, public router:Router,public utilisateurServices:UtilisateurServices) { }

  ngOnInit() {
    if(UtilisateurServices.getUserActiv()!=null){
      this.prop=this.utilisateurServices.getUserActiv();
      console.log("je suis "+this.prop.nom);
    }else {
      console.log("utilisateur null *********");
    }

  }

  saveProjet(){
    this.projet.prop=this.prop;
    this.projetServices.saveProjet(this.projet)
      .subscribe(data=>{
        this.projet=data;
        console.log(data);
      },err=>{
        console.log(err);
      })
  }

}
