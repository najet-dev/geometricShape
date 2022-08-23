import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient }  from '@angular/common/http';
import { IShape } from '../controller/models/I-shape';

import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShapeService {

  apiUrl = environment.apiUrl;

  constructor(public httpClient: HttpClient) { }

  public getShapes() : Observable<IShape>{
    return this.httpClient.get<IShape>(`${this.apiUrl}/shapes`);
  }

  public getShape(shapeId: number){
    return this.httpClient.get<IShape>(`${this.apiUrl}/shapes/${shapeId}`);
  }
  public addShape(shape: IShape){
    return this.httpClient.post<IShape>(`${this.apiUrl}/shapes`, shape);
  }
  public updateShape(shape: IShape): Observable<IShape>{
    return this.httpClient.put<IShape>(`${this.apiUrl}/shapes`, shape);
  }
  public deleteShape(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.apiUrl}/shapes/${id}`)
  }

}
