import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Groupe} from '../model/model.groupe';

@Injectable()
export class GroupeServices{
  constructor(public http:Http){}

  public saveGroupe(groupe:Groupe){
    return this.http.post("http://localhost:8080/groupes/save",groupe)
      .map(resp=>resp.json());
  }

  public groupes(){
    return this.http.get("http://localhost:8080/groupes/list")
      .map(resp=>resp.json());
  }

  public getGroupe(idGroupe:number){
    return this.http.get("http://localhost:8080/groupes/groupe/"+idGroupe)
      .map(resp=>resp.json());
  }

  public deleteGroupe(idGroupe:number){
    return this.http.delete("http://localhost:8080/groupes/delete/"+idGroupe)
      .map(resp=>resp.json());
  }
}
