import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { UpdateDrawingPageRoutingModule } from './update-drawing-routing.module';

import { UpdateDrawingPage } from './update-drawing.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    UpdateDrawingPageRoutingModule
  ],
  declarations: [UpdateDrawingPage]
})
export class UpdateDrawingPageModule {}
