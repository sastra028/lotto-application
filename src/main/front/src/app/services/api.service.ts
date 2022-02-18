import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { API_URL } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http: HttpClient
  ) { }

  lottoSave(number: any, priceA: any, priceB: any): Observable<any> {
    var params = JSON.stringify({
      number: number,
      priceA: priceA,
      priceB: priceB,
    });
    return this.http.post(`${API_URL}/api/lotto/save`, params)
        .pipe(map(results => {
          return results;
        }));
  }

  lottoSave2(form:any): Observable<any> {
    const params = JSON.stringify(form);
    return this.http
      .post(`${API_URL}/api/lotto/save`, params,
        {headers: new HttpHeaders({'Content-Type': 'application/json'}), responseType: 'blob'});
  }

  getList2(): Observable<any> {
    return this.http
      .post(`${API_URL}/api/lotto/list2`,
        {headers: new HttpHeaders({'Content-Type': 'application/json'}), responseType: 'blob'});
  }

  getBill(): Observable<any> {
    return this.http
      .post(`${API_URL}/api/lotto/list-bill`,
        {headers: new HttpHeaders({'Content-Type': 'application/json'}), responseType: 'blob'});
  }

  
  getList3(): Observable<any> {
    return this.http
      .post(`${API_URL}/api/lotto/list3`,
        {headers: new HttpHeaders({'Content-Type': 'application/json'}), responseType: 'blob'});
  }
  
  getList3Main(params:any) {
    return this.http.post(`${API_URL}/api/lotto/list3-main`,params);
  }

}
