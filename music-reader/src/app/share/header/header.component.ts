import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ButtonSecondaryComponent } from '../components/button-secondary/button-secondary.component';
import { ButtonPrimaryComponent } from '../components/button-primary/button-primary.component';
import { SearchBarComponent } from '../components/search-bar/search-bar.component';

@Component({
    selector: 'app-header',
    standalone: true,
    templateUrl: './header.component.html',
    styleUrl: './header.component.scss',
    imports: [SearchBarComponent, ButtonPrimaryComponent, ButtonSecondaryComponent]
})
export class HeaderComponent {
}
