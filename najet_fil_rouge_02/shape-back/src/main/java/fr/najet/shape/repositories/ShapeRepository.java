package fr.najet.shape.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.najet.shape.models.Shape;


@Repository
public interface ShapeRepository extends JpaRepository<Shape, Integer>{
     Shape findById(int id);
}


