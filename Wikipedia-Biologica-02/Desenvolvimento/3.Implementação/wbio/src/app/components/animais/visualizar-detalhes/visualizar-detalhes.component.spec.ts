import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarDetalhesComponent } from './visualizar-detalhes.component';

describe('VisualizarDetalhesComponent', () => {
  let component: VisualizarDetalhesComponent;
  let fixture: ComponentFixture<VisualizarDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarDetalhesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
