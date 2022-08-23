package fr.najet.shape.models;

import javax.persistence.*;

@Entity
@Table(name = "Circle")

public class Circle extends Shape {
    //attribut
    @Column (name="type")
    public String type = "cylinder";
    @Column(name="radius")
    private double radius;
    //float pi = 3.14f;
    //constructor
    public Circle(){
        super();
        radius = 0;
        this.type = "CIRCLE";
    }
    public Circle(int id, int x, int y, double radius){
        super(x, y);
        this.setId(id);
        this.type = "CIRCLE";
        this.radius = radius;
    }
    //methods
    public double getRadius() {return this.radius;}
    public void setRadius(double newRadius) { this.radius = newRadius;}

    @Override
    public String toString() {
        return "Circle: PositionX =" + this.getX() +" " + " PositionY : " + this.getY() + " " + " radius = " + " " +  radius  +"\nArea of circle is : " + getArea() + "\nPerimeter of circle is : "   + getPerimeter();
    }
    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}
