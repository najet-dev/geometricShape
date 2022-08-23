import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ShapePageRoutingModule } from './shape-routing.module';

import { ShapePage } from './shape.page';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        ShapePageRoutingModule,
        ReactiveFormsModule
    ],
  declarations: [ShapePage]
})
export class ShapePageModule {}
