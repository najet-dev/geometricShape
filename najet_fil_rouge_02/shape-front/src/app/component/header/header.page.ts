import { Component, OnInit } from '@angular/core';
import { ShapeService } from '../../service/shape.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.page.html',
  styleUrls: ['./header.page.scss'],
})
export class HeaderPage implements OnInit {
  shapes : any;

  constructor(private shapeService: ShapeService) { }

  ngOnInit() {
  }

}
