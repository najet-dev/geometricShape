package fr.najet.shape.models;


public class Shape3D {
      //Attribut
      private Shape shape;
      private double depth;
      //constructor
      public Shape3D(){
           depth = 0;
      }

      public Shape3D(Shape shape, double depth){
          this.shape = shape;
          this.depth = depth;
     }
     //method
    public double getVolume() {
        return this.shape.getArea() * depth;
    }
}
