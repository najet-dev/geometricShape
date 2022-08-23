
import { AfterViewInit, Component, Input, OnInit } from '@angular/core';

import { ShapeService } from '../../service/shape.service';
import {IShape} from '../../controller/models/I-shape';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {fabric} from 'fabric';
import {newArray} from "@angular/compiler/src/util";


@Component({
  selector: 'app-shape',
  templateUrl: './shape.page.html',
  styleUrls: ['./shape.page.scss'],
})
export class ShapePage implements OnInit {
  shapes : any ;
  canvas : any;
  shapeId: 0;
  shape: IShape = {
    id: 0,
    name: "",
    type : "",
    x: 0,
    y: 0,
    radius: 0,
    length: 0,
    width: 0,
    side1: 0,
    side2: 0,
    side3: 0
  }
  constructor(private shapeService: ShapeService, private fb : FormBuilder) {}
  ngOnInit(){
    this.getShapes();
  }
  public getShapes() {
    this.shapeService.getShapes().subscribe((shapesFromService => {
        // console.dir(shapesFromService);
        this.shapes = shapesFromService;

      }),
      error => console.log(error));
  }

  shapeForm: FormGroup = this.fb.group({
    type: ['', [Validators.required]],
    name: ['', [Validators.required]],
    x: [0,[Validators.required, Validators.minLength(1)]],
    y: [0,[Validators.required, Validators.minLength(1)]],
    radius: [0,[Validators.minLength(1)]],
    length: [0,[Validators.minLength(1)]],
    width: [0,[Validators.minLength(1)]],
    side1: [0,[Validators.minLength(1)]],
    side2: [0,[Validators.minLength(1)]],
    side3: [0,[Validators.minLength(1)]]

  });
  public submitShape() {
    if (this.shapeForm.valid) {
      console.log(this.shapeForm.value)
      this.shape.type = this.shapeForm.controls['type'].value
      this.shape.x = this.shapeForm.controls['x'].value
      this.shape.y = this.shapeForm.controls['y'].value
      this.shape.radius = this.shapeForm.controls['radius'].value
      this.shape.length = this.shapeForm.controls['length'].value
      this.shape.width = this.shapeForm.controls['width'].value
      this.shape.side1 = this.shapeForm.controls['side1'].value
      this.shape.side2 = this.shapeForm.controls['side2'].value
      this.shape.side3 = this.shapeForm.controls['side3'].value
      console.log(this.shape)
      this.shapeService.addShape(this.shape).subscribe(res=>{
       console.log(res);
       this.shapes.push(res);
        this.shapeForm.reset();
      });
    }
  }
  public deleteShape(id:number) {
    this.shapeService.deleteShape(id).subscribe(shapesFromService=>{
      this.getShapes();
    })
  }
  addCanvas(shape: IShape){
    //console.log(shape)
    this.canvas = new fabric.Canvas('Canvas');
    switch(shape.type){
      case 'CIRCLE':
        const circle = new fabric.Circle({
          radius: shape.radius,
          left: shape.x,
          top: shape.y,
          angle: 0,
          fill: 'violet'
        });
        this.canvas.add(circle);
        this.canvas.renderAll(circle);
        break;
      case 'RECTANGLE':
        const rect = new fabric.Rect({
          width: shape.width,
          height: shape.length,
          left: shape.x,
          top: shape.y,
          angle: 0,
          fill: '#b73a63'
        });
        this.canvas.add(rect);
        this.canvas.renderAll(rect);
        break;
      case 'TRIANGLE':
        const triangle = new fabric.Triangle({
          // @ts-ignore
          side1: shape.side1,
          side2: shape.side2,
          side3: shape.side3,
          left: shape.x,
          top: shape.y,
          angle: 0,
          fill: 'greenyellow'
        });
        this.canvas.add(triangle);
        this.canvas.renderAll(triangle);
        break;
      default:
        break;
    }
  }
}
