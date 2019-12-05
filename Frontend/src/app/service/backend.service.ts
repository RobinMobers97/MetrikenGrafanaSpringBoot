import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BackendService {


  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({
      accept: 'application/json',
    })
  };

  public getPrimzahlen(): Observable<Array<number>> {
    return this.http.get<Array<number>>('/prim/getPrim', this.httpOptions);
  }

  public setPrimzahlen(limit: number): Observable<boolean> {
    return this.http.get<boolean>('/prim/setPrim?limit=' + limit, this.httpOptions);
  }

  public getFibonacciZahlen(): Observable<Array<number>> {
    return this.http.get<Array<number>>('/fibonacci/getFibonacci', this.httpOptions);
  }

  public setFibonacciZahlen(limit: number): Observable<boolean> {
    return this.http.get<boolean>('/fibonacci/setFibonacci?limit=' + limit, this.httpOptions);
  }
}
