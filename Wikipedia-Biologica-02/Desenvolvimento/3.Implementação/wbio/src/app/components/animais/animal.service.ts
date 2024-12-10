import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { endWith, Observable } from 'rxjs';
import { Animal } from './animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {
  
  private readonly API = "http://localhost:8080"

  constructor(private http : HttpClient) { }

  editarAnimal(animal: Animal): Observable<Animal> {
    var endpoint = "/animais/atualizarAnimal/"
    const headerDict = {
      'Authorization': 'Bearer ' + sessionStorage.getItem('auth-token'),
    }
    
    const requestOptions = {                                                                                                                                                                                 
      headers: new HttpHeaders(headerDict), 
    };
    return this.http.put<Animal>(this.API + endpoint + animal.id, animal, requestOptions)
  }

  listar() : Observable<Animal[]> {
    var endpoint = "/animais"
    return this.http.get<Animal[]>(this.API + endpoint)
  }

  buscarPorId(id : Number) : Observable<Animal> {
    var endpoint = "/animais/getDadosAnimal/" + id;
    return this.http.get<Animal>(this.API + endpoint)
  }

  
  cadastrarAnimal(animal: Animal): Observable<Animal>{
    var endpoint = "/animais/adicionarAnimal"
    return this.http.post<Animal>(this.API + endpoint, animal)
  }

  removerAnimal(animal: Animal){
     var endpoint = "/animais/removerAnimal"
     return this.http.post(this.API + endpoint, animal)
  }

  pesquisarAnimais(nomePesquisa: string) {
    var endpoint = "/animais/pesquisar/"
    return this.http.get<Animal[]>(this.API + endpoint + nomePesquisa)
  }
}
