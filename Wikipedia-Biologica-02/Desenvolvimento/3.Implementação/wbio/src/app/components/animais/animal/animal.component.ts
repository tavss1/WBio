import { Component, Input, input } from '@angular/core';
import { Animal } from '../animal';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { AnimalService } from '../animal.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-animal',
  standalone: true,
  imports: [RouterLink, NgIf],
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

  @Input() Admin : boolean = false

  constructor(private service : AnimalService, private router: Router, private route : ActivatedRoute, private toastservice : ToastrService){}

  remover(animal : Animal) {
    this.service.removerAnimal(animal).subscribe({
      next: () => {this.toastservice.success("Animal excluido com sucesso!"); this.router.navigate(["listarAnimais"])},
      error: () => {this.toastservice.error("Erro ao excluir Animal!");}
    })
  }

}
