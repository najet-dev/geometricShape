package fr.najet.shape.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shape3D", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Shape3DList {
    //Attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = {CascadeType.REMOVE})
    public ArrayList <Shape3D> shapes3DList;
    //constructor
    public Shape3DList() {
        this.shapes3DList = new ArrayList<>();
    }
    public Shape3DList(int id, List <Shape3D> shapes3DList){
        this.id = id;
        this.shapes3DList = (ArrayList<Shape3D>) shapes3DList;
    }
    //methods
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addShape3D (Shape3D shape3D ) {
        this.shapes3DList.add(shape3D);
    }
    public ArrayList<Shape3D> getShapes3D() {
        return shapes3DList;
    }
    public void removeShape(Shape3D shape3D){
        this.shapes3DList.remove(shape3D);
    }

    public double getTotalVolume() {
        double volume = 0;
        for (Shape3D shape3D: this.shapes3DList) {
            volume += shape3D.getVolume();
        }
        return volume;
    }
    public String toString(){
        return "Total of volume is : " + getTotalVolume();
    }
    public void display() {
        System.out.println(this.toString());
    }
}

