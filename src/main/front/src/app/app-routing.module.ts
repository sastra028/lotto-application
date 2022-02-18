import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent} from './main/main.component';
import { LoginComponent} from './login/login.component';
import {SidenavComponent} from './navigation/sidenav/sidenav.component';
import { HomeComponent} from './home/home.component';
import { ListMainComponent} from './list-main/list-main.component';
import { ListThreeComponent} from './list-three/list-three.component';
const routes: Routes = [
  // {path: '', redirectTo: 'login', pathMatch: 'full'},
  // {path: 'login', component: LoginComponent},
  // {
  //   path: 'page', component: SidenavComponent, children: [
  //     {path: '', redirectTo: 'main', pathMatch: 'full'},
  //     {path: 'main', component: MainComponent},
  //   ]
  // }
  // {path: '', redirectTo: 'main', pathMatch: 'full'},
  // {path: 'login', component: LoginComponent}, 
  {path: '', component: MainComponent}, 
  {path: 'home', component: HomeComponent}, 
  {path: 'list-main', component: ListMainComponent}, 

  // {
  //   path: 'smt', component: SidenavComponent, children: [
  //     // {path: '', redirectTo: 'list', pathMatch: 'full', canActivate: [AuthGuard]},
  //     {path: 'list', component: ListThreeComponent, canActivate: [AuthGuard]},
  //   ]
  // },

  // {path: 'main', component: HomeComponent},
  // {
  //   path: 'page', component: SidenavComponent, children: [
  //     {path: '', redirectTo: 'main', pathMatch: 'full'},
  //     {path: 'main', component: MainComponent},
  //   ]
  // }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
