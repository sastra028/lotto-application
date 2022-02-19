import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import { MatGridListModule } from '@angular/material/grid-list';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component'; 
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import { SidenavComponent } from './navigation/sidenav/sidenav.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { ListTwoComponent } from './list-two/list-two.component';
import { ListThreeComponent } from './list-three/list-three.component';
import { ListMainComponent } from './list-main/list-main.component';
import { MatTabsModule } from '@angular/material/tabs';
import { ListBillComponent } from './list-bill/list-bill.component';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { ListThreeZeroComponent } from './list-three-zero/list-three-zero.component';
import { ListThreeOneComponent } from './list-three-one/list-three-one.component';
import { ListThreeTwoComponent } from './list-three-two/list-three-two.component';
import { ListThreeThreeComponent } from './list-three-three/list-three-three.component';
import { ListThreeFourComponent } from './list-three-four/list-three-four.component';
import { ListThreeFiveComponent } from './list-three-five/list-three-five.component';
import { ListThreeSixComponent } from './list-three-six/list-three-six.component';
import { ListThreeSevenComponent } from './list-three-seven/list-three-seven.component';
import { ListThreeNightComponent } from './list-three-night/list-three-night.component';
import { ListThreeNineComponent } from './list-three-nine/list-three-nine.component';
import { ListThreeTenComponent } from './list-three-ten/list-three-ten.component';
import { MainTestComponent } from './main-test/main-test.component';
import { MainOneComponent } from './main-one/main-one.component';
import { MainTwoComponent } from './main-two/main-two.component';
import { MainThreeComponent } from './main-three/main-three.component';
import { MainFourComponent } from './main-four/main-four.component';
import { ListBillCardComponent } from './list-bill-card/list-bill-card.component';
import { ListBillCardTestComponent } from './list-bill-card-test/list-bill-card-test.component';
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    HomeComponent,
    SidenavComponent,
    ListTwoComponent,
    ListThreeComponent,
    ListMainComponent,
    ListBillComponent,
    ListThreeZeroComponent,
    ListThreeOneComponent,
    ListThreeTwoComponent,
    ListThreeThreeComponent,
    ListThreeFourComponent,
    ListThreeFiveComponent,
    ListThreeSixComponent,
    ListThreeSevenComponent,
    ListThreeNightComponent,
    ListThreeNineComponent,
    ListThreeTenComponent,
    MainTestComponent,
    MainOneComponent,
    MainTwoComponent,
    MainThreeComponent,
    MainFourComponent,
    ListBillCardComponent,
    ListBillCardTestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatTableModule,
    MatInputModule,
    FormsModule,
    MatGridListModule,
    MatToolbarModule,
    MatSidenavModule,
    HttpClientModule,
    MatTabsModule,
    MatIconModule,
    MatMenuModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
