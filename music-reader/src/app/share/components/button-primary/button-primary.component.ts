import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button-primary',
  standalone: true,
  imports: [],
  templateUrl: './button-primary.component.html',
  styleUrl: './button-primary.component.scss'
})
export class ButtonPrimaryComponent {
  @Input() text !: string;
  @Output() click = new EventEmitter<number>();
  clickIncrement : number = 0;
  clickHandler($event : any){
    this.click.emit(++this.clickIncrement);
  }
}
