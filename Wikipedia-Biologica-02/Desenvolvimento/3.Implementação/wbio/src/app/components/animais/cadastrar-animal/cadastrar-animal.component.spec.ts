import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarAnimalComponent } from './cadastrar-animal.component';

describe('CadastrarAnimalComponent', () => {
  let component: CadastrarAnimalComponent;
  let fixture: ComponentFixture<CadastrarAnimalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CadastrarAnimalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastrarAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
