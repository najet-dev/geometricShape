import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'header',
    loadChildren: () => import('./component/header/header.module').then( m => m.HeaderPageModule)
  },
  {
    path: 'drawing',
    loadChildren: () => import('./component/drawing/drawing.module').then( m => m.DrawingPageModule)
  },
  {
    path: 'shape',
    loadChildren: () => import('./component/shape/shape.module').then( m => m.ShapePageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./component/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'update-drawing',
    loadChildren: () => import('./component/update-drawing/update-drawing.module').then( m => m.UpdateDrawingPageModule)
  },
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
