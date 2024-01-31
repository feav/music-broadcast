import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button-secondary',
  standalone: true,
  imports: [],
  templateUrl: './button-secondary.component.html',
  styleUrl: './button-secondary.component.scss'
})
export class ButtonSecondaryComponent {

  @Input() text !: string;
  @Output() click = new EventEmitter<number>();
  clickIncrement : number = 0;
  clickHandler($event : any){
    this.click.emit(++this.clickIncrement);
  }
}
