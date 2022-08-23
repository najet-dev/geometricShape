package fr.najet.shape.models;

import javax.persistence.*;

@Entity
@Table(name = "shape")
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected int x, y;
    @Column(name="type")
    protected String type;
    public Shape(){
        this.x = 0;
        this.y = 0;
    }
    public Shape(int x, int y){
        this.x = x;
        this.y = y;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return this.x;
    }
    public void setXPosition(int x){
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setYPosition(int x){
        this.x = x;
    }

    public  abstract double getArea();

    public abstract double getPerimeter();

    public void display() {
        System.out.println(this.toString());
    }
}

