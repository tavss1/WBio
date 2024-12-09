import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { AnimalComponent } from "../animal/animal.component";
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';
import { AutenticacaoService } from '../../auth/login.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-animais',
  imports: [NgIf, AnimalComponent, NgFor],
  templateUrl: './listar-animais.component.html',
  styleUrl: './listar-animais.component.css'
})

export class ListarAnimaisComponent {

  listaAnimais : Animal[] = [];

  public isAdminValue:boolean = false;

  constructor(private servico : AnimalService, private autenticateService : AutenticacaoService){
    this.isAdmin()
  }

  ngOnInit() : void {
    this.servico.listar().subscribe((listaAnimais) => {
      this.listaAnimais = listaAnimais
    }); 
  }

  async isAdmin(){

    (await this.autenticateService.checkAdmin()).subscribe({
      next: () => {this.isAdminValue = true},
      error: () => {this.isAdminValue = false}
    })

  }

}
