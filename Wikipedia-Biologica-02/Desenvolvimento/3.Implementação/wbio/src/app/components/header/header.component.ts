import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router, RouterLink } from '@angular/router';
import { AutenticacaoService } from '../auth/login.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  constructor(private autenticateService : AutenticacaoService,
              private route : Router,
              private router : ActivatedRoute
  ) {
    
  }

  ngOnInit() : void {
  }

  async isAdmin(){

    (await this.autenticateService.checkAdmin()).subscribe({
      next: () => {this.route.navigate(["cadastrarAnimal"])},
      error: () => {this.route.navigate(["login"])}
    })

  }

}
