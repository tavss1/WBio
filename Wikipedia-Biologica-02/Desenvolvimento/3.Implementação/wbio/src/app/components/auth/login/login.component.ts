import { ActivatedRoute, Router } from '@angular/router';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AutenticacaoService } from '../login.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  credenciais = {
    email: '',
    senha: ''
  }

  constructor(private servico : AutenticacaoService, 
    private toastservice : ToastrService, 
    private router: Router,
    private route : ActivatedRoute){}

  login() : void {
    this.servico.login(this.credenciais.email, this.credenciais.senha).subscribe({
      next: () => {this.toastservice.success("Login feito com sucesso !"); this.router.navigate(['/listarAnimais']); },
      error: () => this.toastservice.error("Erro ao realizar Login !")
    })
  }

}
