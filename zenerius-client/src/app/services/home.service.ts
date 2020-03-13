import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private server_url = "http://localhost:8080";

  constructor(private httpClient : HttpClient) { }

  public get(): Observable<String>{
    console.log("request");
    return this.httpClient.get(this.server_url + '/home/example',  {responseType: 'text'});
  }
}
