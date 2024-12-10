import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { AnimalComponent } from "../animal/animal.component";
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';
import { AutenticacaoService } from '../../auth/login.service';
import { Observable } from 'rxjs';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  selector: 'app-listar-animais',
  imports: [NgIf, AnimalComponent, NgFor, FormsModule],
  templateUrl: './listar-animais.component.html',
  styleUrl: './listar-animais.component.css'
})

export class ListarAnimaisComponent {

  listaAnimais : Animal[] = [];
  nomePesquisa: string = '';

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

  pesquisarAnimais() {
    if (this.nomePesquisa) {
      this.servico.pesquisarAnimais(this.nomePesquisa).subscribe(
        (data: Animal[]) => {
          this.listaAnimais = data;
        },
        (error: any) => {
          console.error('Erro na pesquisa de animais', error);
        }
      );
    } else {
      // Se o campo de pesquisa estiver vazio, recarregue todos os animais
      this.servico.listar().subscribe(
        (data: Animal[]) => {
          this.listaAnimais = data;
        }
      );
    }

  }
}
