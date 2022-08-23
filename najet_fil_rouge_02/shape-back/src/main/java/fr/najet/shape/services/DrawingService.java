package fr.najet.shape.services;

import fr.najet.shape.models.Drawing;
import fr.najet.shape.models.Shape;
import fr.najet.shape.repositories.DrawingRepository;
import fr.najet.shape.repositories.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrawingService {
    @Autowired
    DrawingRepository drawingRepository;
    @Autowired
    ShapeRepository shapeRepository;

    public List<Drawing> getDrawings(){
        return drawingRepository.findAll();
    }

    public Drawing saveDrawing(Drawing drawing){
        return drawingRepository.save(drawing);
    }

    public Drawing getDrawing(int id){return drawingRepository.findById(id);}

    public void updateDrawing(Drawing drawing){drawingRepository.save(drawing);}

    public void deleteDrawing(int id){  drawingRepository.deleteById(id);}

    public Drawing findDrawingWithShape(int shapeID){
        Drawing d = drawingRepository.findByShapesList_Id(shapeID);

        return d;
    }


}


