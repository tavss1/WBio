import { Component, Input, input } from '@angular/core';
import { Animal } from '../animal';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-animal',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './animal.component.html',
  styleUrl: './animal.component.css'
})
export class AnimalComponent {

  @Input() animal : Animal = {
    id : 0,
    nomePopular: '',
    habitat: '',
    alimentacao: '',
    peso: '',
    filo: '',
    classe: '',
    ordem: '',
    familia: '',
    genero: '',
    especie: '',
    descricao: '',
    imagem: ''
  }

}
