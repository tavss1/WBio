import { Routes } from '@angular/router';
import { ListarAnimaisComponent } from './components/animais/listar-animais/listar-animais.component';
import { VisualizarDetalhesComponent } from './components/animais/visualizar-detalhes/visualizar-detalhes.component';
import { LoginComponent } from './components/auth/login/login.component';
import { CadastrarAnimalComponent } from './components/animais/cadastrar-animal/cadastrar-animal.component';
import { EditarAnimalComponent } from './components/animais/editar-animal/editar-animal.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'listarAnimais',
        pathMatch: 'full'
    },
    {
        path:'listarAnimais',
        component: ListarAnimaisComponent
    },
    {
        path:'animais/visualizarDetalhes/:id',
        component: VisualizarDetalhesComponent
    },
    {
        path:'login',
        component: LoginComponent
    },
    {
        path:'cadastrarAnimal',
        component: CadastrarAnimalComponent
    },
    {
        path:'animais/editarAnimal/:id',
        component: EditarAnimalComponent
    }

];
