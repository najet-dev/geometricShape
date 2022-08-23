import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UpdateDrawingPage } from './update-drawing.page';

const routes: Routes = [
  {
    path: '',
    component: UpdateDrawingPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UpdateDrawingPageRoutingModule {}
