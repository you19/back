import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Ressources} from '../model/model.ressources';

@Injectable()
export class RessourceServices{
  constructor(public http:Http){}

  public saveRessource(ressource:Ressources){
    return this.http.post("http://localhost:8080/ressources/save",ressource)
      .map(resp=>resp.json());
  }

  public ressources(){
    return this.http.get("http://localhost:8080/ressources/list")
      .map(resp=>resp.json());
  }

  public deleteRessource(idRes:number){
    return this.http.delete("http://localhost:8080/ressources/delete/"+idRes)
      .map(resp=>resp.json());
  }
}
