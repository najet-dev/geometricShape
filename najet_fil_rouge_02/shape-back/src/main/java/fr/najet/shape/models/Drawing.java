package fr.najet.shape.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drawing", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Drawing {
    //Attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = {CascadeType.REMOVE})
    public final List<Shape> shapesList;


    //public ArrayList <Shape> shapes = new ArrayList<>();
    //constructor
    public Drawing() {
        this.shapesList = new ArrayList<>();
    }

    public Drawing(int id, List<Shape> shapesList) {
        this.id = id;
        this.shapesList = shapesList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shape> getShapesList() {
        return shapesList;
    }

    //methods
    public void addShape(Shape shape) {
        this.shapesList.add(shape);
    }

    public void removeShape(Shape shape){
        this.shapesList.remove(shape);
    }
    public double getTotalArea() {
        double totalArea = 0;
        for (Shape shape: shapesList) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }
    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for (Shape shape: shapesList) {
            totalPerimeter += shape.getPerimeter();
        }
        return totalPerimeter;
    }
    public String toString(){
        return "Total of area is : " + getTotalArea() + "cm2" + " \nTotal of perimetre  is : " + getTotalPerimeter() ;
    }



    public void display() {
        System.out.println(this.toString());
    }
    
}
