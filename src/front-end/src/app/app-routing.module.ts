import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent} from './main/main.component';
import { LoginComponent} from './login/login.component';
import {SidenavComponent} from './navigation/sidenav/sidenav.component';
import { HomeComponent} from './home/home.component';
const routes: Routes = [
  // {path: '', redirectTo: 'login', pathMatch: 'full'},
  // {path: 'login', component: LoginComponent},
  // {
  //   path: 'page', component: SidenavComponent, children: [
  //     {path: '', redirectTo: 'main', pathMatch: 'full'},
  //     {path: 'main', component: MainComponent},
  //   ]
  // }
  {path: '', redirectTo: 'main', pathMatch: 'full'},
  // {path: 'login', component: LoginComponent}, 
  {path: 'main', component: MainComponent}, 
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
