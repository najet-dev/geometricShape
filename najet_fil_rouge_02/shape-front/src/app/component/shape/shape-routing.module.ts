import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ShapePage } from './shape.page';

const routes: Routes = [
  {
    path: '',
    component: ShapePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ShapePageRoutingModule {}
