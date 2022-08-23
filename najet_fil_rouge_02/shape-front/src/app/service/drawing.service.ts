import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Idrawing} from'../controller/models/I-drawing';
import * as fabric from "fabric/fabric-impl";
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class DrawingService {

apiUrl = environment.apiUrl;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  constructor(public httpClient: HttpClient) { }

  public getDrawings() : Observable<Idrawing>{
    return this.httpClient.get<Idrawing>(`${this.apiUrl}/drawings`);
  }
  public getDrawing(id: number): Observable<Idrawing> {
      return this.httpClient.get<Idrawing>(`${this.apiUrl}/drawings/${id}`);
    }
   public  addDrawing(drawing: any){
      return this.httpClient.post(`${this.apiUrl}/drawings`, drawing);
    }
  public  deleteDrawing(drawingId: number): Observable<any>{
      return this.httpClient.delete(`${this.apiUrl}/drawings/${drawingId}`, {responseType: 'text'});
    }

//permet de supprimer la forme du dessin
  removeShapeFromDrawing(idDrawing: number, idShape: number) {
    return this.httpClient.delete(`${this.apiUrl}/drawings/${idDrawing}/${idShape}`,this.httpOptions );
  }
  addShapeFromDrawing(drawingId: number,  shapeId: number){
    return this.httpClient.post(`${this.apiUrl}/drawings/${drawingId}/${shapeId}`, null).subscribe();
  }


}
