import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { AnimalComponent } from "../animal/animal.component";
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';

@Component({
  selector: 'app-listar-animais',
  imports: [NgIf, AnimalComponent, NgFor],
  templateUrl: './listar-animais.component.html',
  styleUrl: './listar-animais.component.css'
})
export class ListarAnimaisComponent {

  listaAnimais : Animal[] = [];

  constructor(private servico : AnimalService){}

  ngOnInit() : void {
    this.servico.listar().subscribe((listaAnimais) => {
      this.listaAnimais = listaAnimais
    });
  }

}
