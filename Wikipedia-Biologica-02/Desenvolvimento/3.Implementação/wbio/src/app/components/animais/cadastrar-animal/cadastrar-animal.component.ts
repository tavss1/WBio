import { Component } from '@angular/core';
import { Animal } from '../animal';
import { FormsModule } from '@angular/forms';
import { AnimalService } from '../animal.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-cadastrar-animal',
  imports: [FormsModule, RouterLink],
  templateUrl: './cadastrar-animal.component.html',
  styleUrl: './cadastrar-animal.component.css'
})
export class CadastrarAnimalComponent {
  animal : Animal = {
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

  constructor(private service : AnimalService, private router : Router, 
    private route : ActivatedRoute,
    private toastservice : ToastrService){}

  cadastrar() {
    this.service.cadastrarAnimal(this.animal).subscribe({
      next: () => {this.toastservice.success("Animal cadastrado com sucesso!"); this.router.navigate(["listarAnimais"])},
      error: () => {this.toastservice.error("Erro ao cadastrar Animal!");}
    })
  }


}
