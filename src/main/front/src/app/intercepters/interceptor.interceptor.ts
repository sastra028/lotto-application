import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpResponse, HttpErrorResponse
} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
// import {LoginService} from "../services/login.service";
// import {TranslateService} from "@ngx-translate/core";
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";
import {catchError, map} from "rxjs/operators";
// import {AlertDialogComponent} from "../component/alert-dialog/alert-dialog.component";

@Injectable()
export class InterceptorInterceptor implements HttpInterceptor {

  constructor(
    private dialog: MatDialog,
    private router: Router,
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(" start intercept ");
    // if (!request.url.includes("/login")) {
    //   const token = this.loginService.getToken();
      
    //   if (token) {
    //     request = request.clone({
    //       setHeaders: {
    //         'Authorization': 'Bearer ' + token
    //       }
    //     });
    //   }
    // }

    // if (!request.headers.has('Content-Type')) {
    // 	request = request.clone({
    // 		setHeaders: {
    // 			'content-type': 'application/json'
    // 		}
    // 	});
    // }

    // request = request.clone({
    // 	headers: request.headers.set('Accept', 'application/json')
    // });

    return next.handle(request).pipe(
      map((event: HttpEvent<any>) => {
        if (event instanceof HttpResponse) {
          // console.log('event--->>>', event);
        }
        return event;
      }),
      catchError( (error: HttpErrorResponse) => {
        console.log("intercept ", error);
        // if (error.status === 401) {
        //   if (this.loginService.isLogin()) {
        //     this.loginService.logout();
        //     this.router.navigate(['/login']);

        //     this.translateService.get("ERROR.INVALID_JWT").subscribe({
        //       next: (message) => {
        //         this.dialog.open(AlertDialogComponent, {
        //           width: '350px',
        //           data: {message: message, type: "ERROR"},
        //         });
        //       }
        //     });
        //   }
        // }
        // if (error.url?.includes("login") && error.status === 0) {
        //   this.translateService.get("ERROR.CONECTION_REFUSED").subscribe({
        //     next: (message) => {
        //       this.dialog.open(AlertDialogComponent, {
        //         width: '350px',
        //         data: {message: message, type: "ERROR"},
        //       });
        //     }
        //   });
        // }
        // console.log("Interceptor", error);
        return throwError(error);
      }));
  }

  async alertWithErrorCode(errorCode: string) {
    // let errorMessage = await this.translateService.get(errorCode).toPromise();
    // let btnOk = await this.translateService.get('ERROR.ALERT.OK');
    // this.dialog.open(AlertDialogComponent, {
    //   width: '350px',
    //   data: { message: errorMessage, type: "ERROR" },
    // });
  }
}
