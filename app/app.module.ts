import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import {UtilisateurServices} from '../services/utilisateur.services';
import {RouterModule, Routes} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import { AddProjetComponent } from './projet/add-projet/add-projet.component';
import {GroupeServices} from '../services/groupe.services';
import {ProjetServices} from '../services/projet.services';
import {RessourceServices} from '../services/ressource.services';
import { GroupeComponent } from './groupe/groupe/groupe.component';
import { RessourceComponent } from './ressource/ressource/ressource.component';
import { LoginComponent } from './login/login.component';
import { ProjetComponent } from './projet/projet/projet.component';
import { HeaderComponent } from './header/header.component';


const appRoutes:Routes=[
  {path: '', redirectTo: '/login', pathMatch: 'full' },
  {path:'saveUtilisateur',component:UtilisateurComponent},
  {path:'saveProjet',component:AddProjetComponent},
  {path:'groupes',component:GroupeComponent},
  {path:'ressource',component:RessourceComponent},
  {path:'login',component:LoginComponent},
  {path:'projet',component:ProjetComponent},
];



@NgModule({
  declarations: [
    AppComponent,
    UtilisateurComponent,
    AddProjetComponent,
    GroupeComponent,
    RessourceComponent,
    LoginComponent,
    ProjetComponent,
    HeaderComponent,
    
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),HttpModule,FormsModule
  ],
  providers: [
    UtilisateurServices,
    GroupeServices,
    ProjetServices,
    RessourceServices
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
