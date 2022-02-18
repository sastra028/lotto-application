import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent} from './main/main.component';
import { LoginComponent} from './login/login.component';
import {SidenavComponent} from './navigation/sidenav/sidenav.component';
import { HomeComponent} from './home/home.component';
import { ListMainComponent} from './list-main/list-main.component';
import { ListThreeComponent} from './list-three/list-three.component';
import { MainTestComponent } from './main-test/main-test.component';
const routes: Routes = [
  {path: '', component: MainComponent}, 
  {path: 'home', component: HomeComponent}, 
  {path: 'list-main', component: ListMainComponent}, 

  {path: '', redirectTo: 'class-attendance', pathMatch: 'full'},
  { path: 'login', component: LoginComponent },
  {
    path: 'class-attendance', component: SidenavComponent, children: [
      {path: '', redirectTo: 'class-session-search', pathMatch: 'full'},
      { path: 'class-session-create', component: MainComponent},
      { path: 'class-session-qr', component: ListThreeComponent},
      { path: 'class-session-search', component:MainTestComponent},
      { path: 'class-session-qr-v2', component:HomeComponent},
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
