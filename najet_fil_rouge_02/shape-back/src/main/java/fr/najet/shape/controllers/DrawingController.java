package fr.najet.shape.controllers;

import fr.najet.shape.dto.ShapeDto;
import fr.najet.shape.dto.ShapeTypeEnum;
import fr.najet.shape.exception.ApiRequestException;
import fr.najet.shape.models.Drawing;
import fr.najet.shape.models.Shape;
import fr.najet.shape.repositories.DrawingRepository;
import fr.najet.shape.services.ShapeService;
import fr.najet.shape.services.DrawingService;
import fr.najet.shape.repositories.ShapeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin()
@RestController
@RequestMapping()

public class DrawingController {
    @Autowired
    public DrawingService drawingService;
    @Autowired
    public ShapeService shapeService;

    public Drawing drawing;
    /**
     * Read - Get all drawings
     * @return -A list objet of drawing full filled
     */
    @GetMapping("/drawings")
    public List<Drawing> getDrawings(){
        return drawingService.getDrawings();
    }
    /**
     * Create - create a drawing
     * @return -A list objet of drawing full filled
     */
    @PostMapping("/drawings")
    public Drawing addDrawing(@RequestBody Drawing drawing) {
        Drawing newDrawing =  drawingService.saveDrawing(drawing);
        return newDrawing;
    }
    /**
     * Add a shape into drawing
     * @param drawingId
     * @param shapeId
     */
    @PostMapping("drawings/{drawingId}/{shapeId}")
    public void addShapeFromDrawing(@PathVariable int drawingId, @PathVariable int shapeId){
        Shape shape = shapeService.getShape(shapeId);
        Drawing drawing= getDrawingById(drawingId);
        drawing.addShape(shape);
        drawingService.saveDrawing(drawing);
    }
    /**
     * Remove a shape into drawing
     * @param drawingId
     * @param shapeId
     */
    @DeleteMapping("drawings/{drawingId}/{shapeId}")
    public Drawing removeShapeFromDrawing(@PathVariable int drawingId, @PathVariable int shapeId){
        Drawing drawing = drawingService.getDrawing(drawingId);
        Shape shape = shapeService.getShape(shapeId);
        drawing.removeShape(shape);
        drawingService.saveDrawing(drawing);
        return drawing;
    }
    /**
     * Read - Get one drawing
     * @param id The id of the drawing
     * @return A drawing object full filled
     */
    @GetMapping(value = "/drawings/{id}")
    public Drawing getDrawingById(@PathVariable("id") int id){
        Drawing drawing = drawingService.getDrawing(id);
        if (drawing == null) throw new ApiRequestException("Oops cannot get drawing with id "+ id  + " is not found");
        return drawingService.getDrawing(id);
    }
    /**
     * Modify - modify a drawing
     * @param drawing- The drawing is modified
     */
    @PutMapping(value = "/drawings")
    public void updateDrawing(@RequestBody Drawing drawing) {
        drawingService.updateDrawing(drawing);
    }
    /**
     * Delete - Delete a drawing
     * @param id - The id of the drawing to delete
     * @return
     */
    @DeleteMapping("/drawings/{id}")
    public String deleteDrawing(@PathVariable  int id) {
        drawingService.deleteDrawing(id);
        if(drawing != null) drawingService.deleteDrawing(id);
        return "drawing is delete.......";
    }
}