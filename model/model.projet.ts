import {Utilisateur} from './model.utilisateur';

export class Projet{
  idProjet:number=0;
  nomCourt:string='';
  nomLong:string='';
  description:string='';
  theme:string='';
  type:boolean=true;
  valide:boolean=false;
  prop:Utilisateur=new Utilisateur();
}
