import { Routes } from '@angular/router';
import { ListMusicComponent } from './pages/list-music/list-music.component';
import { MyMusicComponent } from './pages/my-music/my-music.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';

export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    { path: 'home', component: ListMusicComponent },
    { path: 'my-musics', component: MyMusicComponent },
    { path: '**', component: NotFoundComponent }
];
