import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from './autenticacao.type';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {

  private readonly API = "http://54.156.58.163:8080"

  constructor(private http : HttpClient) { }

  login(login : String, password : String){

    return this.http.post<LoginResponse>(this.API + "/auth/login", {login, password}).pipe(
      tap((value) => {
        sessionStorage.setItem("auth-token", value.token)
      })
    )
    
  }

  async checkAdmin() {

    const headerDict = {
      'Authorization': 'Bearer ' + sessionStorage.getItem('auth-token'),
    }
    
    const requestOptions = {                                                                                                                                                                                 
      headers: new HttpHeaders(headerDict), 
    };
    return await this.http.get(this.API + "/auth/check", requestOptions)
  }
}
