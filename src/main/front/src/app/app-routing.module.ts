import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { MainComponent} from './main/main.component';
// import { LoginComponent} from './login/login.component';
import {SidenavComponent} from './navigation/sidenav/sidenav.component';
// import { HomeComponent} from './home/home.component';
// import { ListMainComponent} from './list-main/list-main.component';
// import { ListThreeComponent} from './list-three/list-three.component';
// import { MainTestComponent } from './main-test/main-test.component';
// import { ListTwoComponent } from './list-two/list-two.component';
// import { ListThreeOneComponent } from './list-three-one/list-three-one.component';
// import { ListThreeTwoComponent } from './list-three-two/list-three-two.component';
// import { ListThreeThreeComponent } from './list-three-three/list-three-three.component';
// import { ListThreeFourComponent } from './list-three-four/list-three-four.component';
// import { ListThreeFiveComponent } from './list-three-five/list-three-five.component';
// import { ListThreeSixComponent } from './list-three-six/list-three-six.component';
// import { ListThreeSevenComponent } from './list-three-seven/list-three-seven.component';
// import { ListThreeNightComponent } from './list-three-night/list-three-night.component';
// import { ListThreeNineComponent } from './list-three-nine/list-three-nine.component';

import { MainListComponent } from './page/main-list/main-list.component';
import { ListBillComponent } from './page/list-bill/list-bill.component';
import { ListThreeMainZeroComponent } from './page/list-three-main-zero/list-three-main-zero.component';
import { ListTwoComponent } from './page/list-two/list-two.component';
const routes: Routes = [
  // {path: '', component: MainComponent}, 
  // {path: 'home', component: HomeComponent}, 
  // {path: 'list-main', component: ListMainComponent}, 

  // {path: '', redirectTo: 'class-attendance', pathMatch: 'full'},
  // { path: 'login', component: LoginComponent },
  // {
  //   path: 'class-attendance', component: SidenavComponent, children: [
  //     {path: '', redirectTo: 'class-session-search', pathMatch: 'full'},
  //     { path: 'class-session-create', component: MainComponent},
  //     { path: 'class-session-qr', component: ListThreeComponent},
  //     { path: 'class-session-search', component:MainTestComponent},
  //     { path: 'class-session-qr-v2', component:HomeComponent},
  //   ]
  // }

  // {
  //   path: '', component: SidenavComponent, children: [
  //     {path: '', redirectTo: 'list-main', pathMatch: 'full'},
  //     { path: 'list-main', component: ListMainComponent},
  //     { path: 'list-two', component: ListTwoComponent},
  //     { path: 'list-three-one', component: ListThreeOneComponent},
  //     { path: 'list-three-two', component: ListThreeTwoComponent},
  //     { path: 'list-three-three', component: ListThreeThreeComponent},
  //     { path: 'list-three-four', component: ListThreeFourComponent},
  //     { path: 'list-three-five', component: ListThreeFiveComponent},
  //     { path: 'list-three-six', component: ListThreeSixComponent},
  //     { path: 'list-three-seven', component: ListThreeSevenComponent},
  //     { path: 'list-three-night', component: ListThreeNightComponent},
  //     { path: 'list-three-nine', component: ListThreeNineComponent},
  //   ]
  // }

  {
    path: '', component: SidenavComponent, children: [
      {path: '', redirectTo: 'list-main', pathMatch: 'full'},
      { path: 'list-main', component: MainListComponent},
      { path: 'list-bill', component: ListBillComponent},
      { path: 'list-two', component: ListTwoComponent},
      { path: 'list-three-one', component: ListThreeMainZeroComponent},
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
