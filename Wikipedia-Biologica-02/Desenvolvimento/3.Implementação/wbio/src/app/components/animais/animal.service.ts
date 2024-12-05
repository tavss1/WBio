import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { endWith, Observable } from 'rxjs';
import { Animal } from './animal';

@Injectable({
  providedIn: 'root'
})
export class AnimalService {

  private readonly API = "http://ec2-44-223-8-200.compute-1.amazonaws.com:8080"

  constructor(private http : HttpClient) { }

  listar() : Observable<Animal[]> {
    var endpoint = "/animais"
    return this.http.get<Animal[]>(this.API + endpoint)
  }

  buscarPorId(id : Number) : Observable<Animal> {
    var endpoint = "/animais/getDadosAnimal/" + id;
    return this.http.get<Animal>(this.API + endpoint)
  }

  
  cadastrarAnimal(animal: Animal): Observable<Animal>{
    var endpoint = "/adicionarAnimal"
    return this.http.post<Animal>(this.API + endpoint, animal)
  }
}
