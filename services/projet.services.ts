import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Projet} from '../model/model.projet';

@Injectable()
export class ProjetServices{
  constructor(public http:Http){}

  public saveProjet(projet:Projet){
    return this.http.post("http://localhost:8080/projet/save",projet)
      .map(resp=>resp.json());
  }

  public validerProjet(idProjet:number){
    return this.http.get("http://localhost:8080/projet/valider/"+idProjet)
      .map(resp=>resp.json());
  }

  public getProjet(idProjet:number){
    return this.http.get("http://localhost:8080/projet/projet/"+idProjet)
      .map(resp=>resp.json());
  }

  public projets(){
    return this.http.get("http://localhost:8080/projet/list")
      .map(resp=>resp.json());
  }

  public deleteProjet(idProjet:number){
    return this.http.delete("http://localhost:8080/projet/delete/"+idProjet)
      .map(resp=>resp.json());
  }

  editProjet(projet:Projet,id:number){
    return this.http.put("http://localhost:8080/projet/update/"+id,projet).map(resp=>resp.json());
  }
}
