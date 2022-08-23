package fr.najet.shape.models;

import javax.persistence.*;

@Entity
@Table(name = "triangle")

public class Triangle extends Shape {
    // Attribut
    @Column (name="type")
    public String type = "triangle";
    @Column(name="side1")
    private double side1;
    @Column(name="side2")
    private double side2;
    @Column(name="side3")
    private double side3;
    // Constructor
    public Triangle(){
        super();
        this.type = "TRIANGLE";
        side1 = 0;
        side2 = 0;
        side3 = 0;
    }
    public Triangle(int id, int x, int y, double side1, double side2, double side3){
        super( x, y);
        this.setId(id);
        this.type = "TRIANGLE";
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    //methods
    public double getSide1() {return this.side1;}
    public double getSide2() {return this.side2;}
    public double getSide3() {return this.side3;}
    public void setSide1(int newSide1) { this.side1 = newSide1;}
    public void setSide2(int newSide2) { this.side2 = newSide2;}
    public void setSide3(int newSide3) { this.side3 = newSide3;}
    @Override
    public String toString() {
        return  "Triangle: PositionX = " + this.getX() + " " + "\nPositionY = " + this.getY() + " " + " side1 = " + " " + side1+ " , side2 = " + " " + side2 +", side3 = " + side3 + "\nPerimeter of triangle is perimeter :" + getPerimeter() + "\nArea of triangle :" + getArea();
    }
    @Override
    public double getArea(){
        double halfP = getPerimeter()/ 2;
        return  Math.sqrt(halfP * (halfP - side1) * (halfP - side2) * (halfP * side3));
    }
    @Override
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
}
