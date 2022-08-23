import { Component, OnInit, NgModule } from '@angular/core';
import {DrawingService} from "../../service/drawing.service";
import {IShape} from "../../controller/models/I-shape";
import {IDrawing} from "../../controller/models/I-drawing";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";



import {ModalController} from "@ionic/angular";
import {fabric} from "fabric";


@Component({
  selector: 'app-drawing',
  templateUrl: './drawing.page.html',
  styleUrls: ['./drawing.page.scss'],
})
export class DrawingPage implements OnInit {
  //public drawings: newDrawing[] = [];
  drawings : any;
  canvas: any;
  shapes: IShape = {
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
  constructor(private drawingService: DrawingService,
              private fb: FormBuilder, private modal: ModalController) {
  }
  ngOnInit() {
    this.getDrawings()
  }

  public getDrawings() {
    this.drawingService.getDrawings().subscribe((drawingsFromService) => {
      //console.dir(drawingsFromService);
      this.drawings = drawingsFromService;
    });

  }
  drawingForm: FormGroup = this.fb.group({
    name: ['', [Validators.required]]
  });
  addShape: FormGroup = this.fb.group({
    idShape: ['', [Validators.required]],
    idDrawing: ['', [Validators.required]]

  });
  public addDrawing(){
    if (this.drawingForm.valid){
      console.log(this.drawingForm.value)
      let drawing : IDrawing = {
        name: this.drawingForm.controls['name'].value
      }
      this.drawingService.addDrawing(drawing).subscribe(res=> {
        console.log(res);
        this.drawings.push(res);
        this.drawingForm.reset();
      });
    }
  }

  removeShape(drawingId: number, idShape: number) {
    this.drawingService.removeShapeFromDrawing(drawingId,idShape).subscribe(res=>{
      let shapesIndex = this.drawings.findIndex(index => index.id == drawingId);
      this.drawings.splice(shapesIndex, 1);

    });
  //  location.reload();
  }

  deleteDrawing(drawingId) {
    this.drawingService.deleteDrawing(drawingId).subscribe(res =>{
      let shapesIndex = this.drawings.findIndex(index => index.id == drawingId);
      this.drawings.splice(shapesIndex, 1);

    });

    //location.reload();
  }


  addShapeDrawing() {
    if(this.addShape.valid) {
      let idDrawing = this.addShape.controls['idDrawing'].value;
      let idShape =  this.addShape.controls['idShape'].value;
      console.log(idShape, idDrawing)
      this.drawingService.addShapeFromDrawing(idDrawing,idShape);
    }
    location.reload();
  }
  draw(drawing: IDrawing){
    console.log(drawing)

    let showShape:any;
    this.canvas = new fabric.Canvas('canvas');
    // @ts-ignore
    for (let shape of drawing.shapesList){
      switch(shape.type) {
        case "RECTANGLE":
          showShape = new fabric.Rect({
            width: shape.width,
            height: shape.length,
            left: shape.x,
            top: shape.y,
            fill: 'violet'
          });
          console.log(showShape)
          break;
        case "TRIANGLE":
          showShape= new fabric.Triangle({
            // @ts-ignore
            side1: shape.side1,
            side2: shape.side2,
            side3: shape.side3,
            left: shape.x,
            top: shape.y,
            fill: 'green'
          });
          break;
        case "CIRCLE":
          showShape = new fabric.Circle({
            // @ts-ignore
            radius: shape.radius,
            left: shape.x,
            top:  shape.y,
            fill: 'pink'
          });
          break;
      }
      this.canvas.add(showShape);
    }
  }
  addCanvas(shapes: IShape){
    this.canvas = new fabric.Canvas('canvas');
    switch(shapes.type){
      case 'CIRCLE':
        const circle = new fabric.Circle({
          radius: shapes.radius,
          left: shapes.x,
          top: shapes.y,
          angle: 0,
          fill: 'violet'
        });
        this.canvas.add(circle);
        this.canvas.renderAll(circle);
        break;
      case 'RECTANGLE':
        const rect = new fabric.Rect({
          width: shapes.width,
          height: shapes.length,
          left: shapes.x,
          top: shapes.y,
          angle: 0,
          fill: '#b73a63'
        });
        this.canvas.add(rect);
        this.canvas.renderAll(rect);
        break;
      case 'TRIANGLE':
        const triangle = new fabric.Triangle({
          // @ts-ignore
          side1: shapes.side1,
          side2: shapes.side2,
          side3: shapes.side3,
          left: shapes.x,
          top: shapes.y,
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
