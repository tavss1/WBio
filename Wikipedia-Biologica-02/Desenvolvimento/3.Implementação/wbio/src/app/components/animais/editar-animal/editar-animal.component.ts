import { Component } from '@angular/core';
import { Animal } from '../animal';
import { AnimalService } from '../animal.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-editar-animal',
  imports: [FormsModule, RouterLink],
  templateUrl: './editar-animal.component.html',
  styleUrl: './editar-animal.component.css'
})
export class EditarAnimalComponent {
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

  constructor(private service : AnimalService, private router : Router, private route : ActivatedRoute,
    private toastservice : ToastrService
  ){}

  editar() {
    this.service.editarAnimal(this.animal).subscribe({
      next: () => {this.toastservice.success("Animal editado com sucesso!"); this.router.navigate(["listarAnimais"])},
      error: () => {this.toastservice.error("Erro ao editar Animal!");}
    })
  }

  ngOnInit() : void {
    const id = this.route.snapshot.paramMap.get('id');
    this.service.buscarPorId(parseInt(id!)).subscribe((animal) => {
      this.animal = animal;
    })
  }

}
