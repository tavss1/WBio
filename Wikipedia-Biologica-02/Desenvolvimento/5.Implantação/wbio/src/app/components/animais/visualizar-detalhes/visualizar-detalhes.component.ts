import { Component, input, Input } from '@angular/core';
import { AnimalService } from '../animal.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Animal } from '../animal';

@Component({
  selector: 'app-visualizar-detalhes',
  imports: [],
  templateUrl: './visualizar-detalhes.component.html',
  styleUrl: './visualizar-detalhes.component.css'
})
export class VisualizarDetalhesComponent{
  
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

  ngOnInit() : void {
    const id = this.route.snapshot.paramMap.get('id');
    this.service.buscarPorId(parseInt(id!)).subscribe((animal) => {
      this.animal = animal;
    })
  }

}
