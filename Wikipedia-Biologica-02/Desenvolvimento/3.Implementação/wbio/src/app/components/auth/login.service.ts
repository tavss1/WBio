import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from './autenticacao.type';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {

  private readonly API = "http://ec2-44-214-104-15.compute-1.amazonaws.com:8080"

  constructor(private http : HttpClient) { }

  login(login : String, password : String){

    return this.http.post<LoginResponse>(this.API + "/auth/login", {login, password}).pipe(
      tap((value) => {
        sessionStorage.setItem("auth-token", value.token)
      })
    )
    
  }

  checkAdmin() {
    console.log(this.http.get(this.API).subscribe((value) => value.toString))
  }
}
