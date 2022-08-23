package fr.najet.shape.repositories;

import fr.najet.shape.models.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.najet.shape.models.Shape;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing, Integer>{
    Drawing findById(int id);

    Drawing findByShapesList_Id(int id);

}
