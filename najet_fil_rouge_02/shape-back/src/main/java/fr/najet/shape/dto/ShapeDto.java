package fr.najet.shape.dto;

import fr.najet.shape.models.Circle;
import fr.najet.shape.models.Rectangle;
import fr.najet.shape.models.Triangle;


import fr.najet.shape.models.Shape;

public class ShapeDto {
    public ShapeTypeEnum type;
    public int id;
    public int x;
    public int y;
    public double radius;
    public double length;
    public double width;
    public double side1;
    public double side2;
    public double side3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shape createShape() {
        Shape shape = null;
        switch (this.type) {
            case CIRCLE:
                shape = new Circle(this.id, this.x, this.y, this.radius);
                break;
            case RECTANGLE:
                shape = new Rectangle(this.id, this.x, this.y, this.length, this.width);
                break;
            case TRIANGLE:
                shape = new Triangle(this.id, this.x, this.y, this.side1, this.side2, this.side3);
                break;
            default:
                break;
        }
        return shape;
    }
    public Shape updateShape (ShapeDto shapeDto) {
        Shape shape = null;
        switch (this.type) {
            case CIRCLE:
                shape = new Circle(this.id, this.x, this.y, this.radius);
                break;
            case RECTANGLE:
                shape = new Rectangle(this.id, this.x, this.y, this.length, this.width);
                break;
            case TRIANGLE:
                shape = new Triangle(this.id, this.x, this.y, this.side1, this.side2, this.side3);
                break;
            default:
                break;
        }
        return shape;
    }
}


