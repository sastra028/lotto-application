import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  login(){
    // this.router.navigate(['/home']);
    // this.router.navigateByUrl('/home');
    console.log('99999999999999');
    this.router.navigate(["/class-attendance/class-session-search"]);
  }
}
