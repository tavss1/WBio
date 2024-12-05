import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarCadastrarAnimalComponent } from './editar-cadastrar-animal.component';

describe('EditarCadastrarAnimalComponent', () => {
  let component: EditarCadastrarAnimalComponent;
  let fixture: ComponentFixture<EditarCadastrarAnimalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditarCadastrarAnimalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditarCadastrarAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
