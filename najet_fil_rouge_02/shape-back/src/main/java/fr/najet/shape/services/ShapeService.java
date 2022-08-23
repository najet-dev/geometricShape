package fr.najet.shape.services;
import fr.najet.shape.models.Drawing;
import fr.najet.shape.models.Shape;
import fr.najet.shape.repositories.ShapeRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class ShapeService {
    @Autowired
    ShapeRepository shapeRepository;

    @Autowired
    DrawingService drawingService;

    public Iterable<Shape> getShapes(){
        return shapeRepository.findAll();
    }

    public Shape saveShape(Shape shape){
        return shapeRepository.save(shape);
    }

    public Shape getShape(int id){return shapeRepository.findById(id);}

    public void updateShape( Shape shape) {shapeRepository.save(shape);}

  /*  public void deleteShape(int id){
        Drawing drawingWithShape = drawingService.findDrawingWithShape(id);
        Shape toRemove = shapeRepository.findById(id);
        if(drawingWithShape != null) drawingWithShape.removeShape(toRemove);
        drawingService.saveDrawing(drawingWithShape);
        shapeRepository.deleteById(id);
    }*/
    public void deleteShape(int id){ shapeRepository.deleteById(id);}
    
}


