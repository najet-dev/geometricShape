package fr.najet.shape.models;


import javax.persistence.*;


@Entity
@Table(name = "rectangle")

public class Rectangle extends Shape {
    //attribut
    @Column (name="type")
    public String type = "rectangle";
    @Column(name="length")
    private double length;
    @Column(name="width")
    private double width;
    //constructor
    public Rectangle(){
        super();
        length = 0;
        width = 0;
        this.type = "RECTANGLE";
    }
    public Rectangle(int id, int x, int y, double length, double width){
        super( x, y);
        this.setId(id);
        this.type = "RECTANGLE";
        this.length = length;
        this.width = width;
    }
    //methods
    public double getLength() { return this.length;}
    public double getWidth() {return this.width;}
    public void setLength(int newLength) { this.length = newLength;}
    public void setWidth(int newWidth) { this.width = newWidth;}

    @Override
    public String toString() {
        return "Rectangle : PositionX =" + this.getX() + "\nPositionY =" + this.getY() +  "length = " + length + ", width = " + width + " \nArea of rectangle is : " + getArea() + "  \nPerimeter of rectangle is : " + getPerimeter();
    }
    @Override
    public double getArea(){
        return this.length * this.width;
    }
    @Override
    public double getPerimeter(){
        return 2 * (this.length + this.width);
    }
}


