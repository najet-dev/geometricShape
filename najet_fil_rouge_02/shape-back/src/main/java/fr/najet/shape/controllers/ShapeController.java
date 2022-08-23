package fr.najet.shape.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import fr.najet.shape.dto.ShapeDto;
import fr.najet.shape.exception.ApiRequestException;
import fr.najet.shape.models.Shape;
import fr.najet.shape.repositories.ShapeRepository;
import fr.najet.shape.services.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin()
@RequestMapping()
@RestController
public class ShapeController {
    @Autowired
    ShapeRepository shapeRepository;
    @Autowired
    ShapeService shapeService;

    /**
     * Read - Get all shapes
     * @return -An Iterable objet of shape full filled
     */
    @GetMapping("/shapes")
    public Iterable<Shape> getShapes(){
        return shapeService.getShapes();
    }
    /**
     * Create - create a shape
     * @return -An Iterable objet of shape full filled
     */
    @PostMapping("/shapes")
    public Shape saveShape(@RequestBody ShapeDto shapeDto) {
        Shape shape = shapeDto.createShape();
        shapeService.saveShape(shape);
        return shape;
    }
    /**
     * Read - Get one shape
     * @param id The id of the shape
     * @return A shape object full filled
     */
    @GetMapping(path = "/shapes/{id}")
    public Shape getShapeById(@PathVariable(value="id") int id){
        Shape shape = shapeService.getShape(id) ;
        if(shape == null) throw new ApiRequestException("Oops cannot get shape with id "+ id  + " was not found");
        return this.shapeService.getShape(id);
    }
    /**
     * Modify - modify a shape
     * @return shape - The shape is updated
     */
    @PutMapping("/shapes")
    public void updateShape(@RequestBody ShapeDto shapeDto) throws Exception {
        Shape shape = getShapeById(shapeDto.id);
        if(shape == null){
            throw  new Exception("No shape at id" + shapeDto.id);
        }
        Shape newShape = shapeDto.updateShape(shapeDto);
        if(shapeDto.id == shape.getId()) {
            shapeService.updateShape(newShape);
        }
        else {
            System.out.println("Error bad Id");
        }
    }
    /**
     * Delete - Delete a shape
     * @param id - The id of the shape to delete
     * @return shape - The shape is deleted
     */
    @DeleteMapping("/shapes/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteShape(@PathVariable int id) throws Exception{
        shapeService.deleteShape(id);
        return ResponseEntity.noContent().build();
    }


}





