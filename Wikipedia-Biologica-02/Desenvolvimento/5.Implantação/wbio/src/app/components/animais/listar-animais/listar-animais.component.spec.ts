import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarAnimaisComponent } from './listar-animais.component';

describe('ListarAnimaisComponent', () => {
  let component: ListarAnimaisComponent;
  let fixture: ComponentFixture<ListarAnimaisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarAnimaisComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarAnimaisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
