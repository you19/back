import { Component, OnInit } from '@angular/core';
import {RessourceServices} from '../../../services/ressource.services';
import {Ressources} from '../../../model/model.ressources';

@Component({
  selector: 'app-ressource',
  templateUrl: './ressource.component.html',
  styleUrls: ['./ressource.component.css']
})
export class RessourceComponent implements OnInit {

  ressources:Array<any>= new Array(Ressources)

  constructor(public ressourceServices:RessourceServices) { }

  ngOnInit() {
    this.ressourceServices.ressources()
      .subscribe(data=>{
        this.ressources=data;
        console.log(data);
      },err=>{
        console.log(err);
      })
  }

}
