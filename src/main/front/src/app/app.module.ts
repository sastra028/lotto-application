import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import { SidenavComponent } from './navigation/sidenav/sidenav.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { MatTabsModule } from '@angular/material/tabs';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import { MainListComponent } from './page/main-list/main-list.component';
import { ListThreeMainZeroComponent } from './page/list-three-main-zero/list-three-main-zero.component';
import { ListBillComponent } from './page/list-bill/list-bill.component';
import { ListTwoComponent } from './page/list-two/list-two.component';
import {MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
    MainListComponent,
    ListBillComponent,
    ListTwoComponent,
    ListThreeMainZeroComponent
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
    MatMenuModule,
    MatCardModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
