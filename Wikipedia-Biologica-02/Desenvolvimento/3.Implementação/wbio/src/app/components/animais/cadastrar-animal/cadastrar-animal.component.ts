import { Component } from '@angular/core';
import { Animal } from '../animal';
import { FormsModule } from '@angular/forms';
import { AnimalService } from '../animal.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cadastrar-animal',
  imports: [FormsModule],
  templateUrl: './cadastrar-animal.component.html',
  styleUrl: './cadastrar-animal.component.css'
})
export class CadastrarAnimalComponent {
  animal : Animal = {
    id: 0,
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

  constructor(private service : AnimalService, private router : Router, private route : ActivatedRoute){}

  cadastrar() {
    this.service.cadastrarAnimal(this.animal).subscribe()
  }


}
