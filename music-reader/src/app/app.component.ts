import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LeftSideComponent } from "./share/left-side/left-side.component";
import { HeaderComponent } from "./share/header/header.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.scss',
    imports: [RouterOutlet, LeftSideComponent, HeaderComponent]
})
export class AppComponent {
  title = 'music-reader';
}
