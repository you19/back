import { Component, OnInit } from '@angular/core';
import {Projet} from '../../../model/model.projet';
import {ProjetServices} from '../../../services/projet.services';
import {Router} from '@angular/router';
import {UtilisateurServices} from '../../../services/utilisateur.services';
import {Utilisateur} from '../../../model/model.utilisateur';

@Component({
  selector: 'app-projet',
  templateUrl: './projet.component.html',
  styleUrls: ['./projet.component.css']
})
export class ProjetComponent implements OnInit {
  utilisateur:Utilisateur;
  projets:Array<any>=Array(Projet);

  etat:boolean=true;

  constructor(public projetServices:ProjetServices,public router:Router,public utilisateurServices:UtilisateurServices) { }

  ngOnInit() {
    this.utilisateur=this.utilisateurServices.getUserActiv();
    console.log("hhhhhhhhhhhhhhhhhhhhhh"+this.utilisateur.nom);
    if(this.utilisateur == null){
      console.log("hhhhhhhhhhhhhhhhhhhhhh"+this.utilisateur.nom);
      this.router.navigate(['login']);
    }
    this.projetServices.projets()
      .subscribe(data=>{
        console.log(data);
        this.projets=data;
      },err=>{
        console.log("err "+err);
      })
  }

  valider(idProjet:number){
    this.projetServices.validerProjet(idProjet)
      .subscribe(data=>{
        this.projetServices.getProjet(idProjet)
          .subscribe()
        console.log("data faite"+data);
        this.router.navigate(['projet']);
      },err=>{
        console.log("err "+err);
      })
  }

  cloture(idProjet:number,c:Projet){
    c.type=!c.type;
    this.projetServices.editProjet(c,idProjet).subscribe(data=>{
    
    },err=>{
      console.log("err "+err);
    })
  

  }

}
