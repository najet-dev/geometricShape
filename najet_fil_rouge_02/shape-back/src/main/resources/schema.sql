 CREATE TABLE shape (
      id INT PRIMARY KEY AUTO_INCREMENT,
      type VARCHAR(255),
      x DOUBLE,
      y DOUBLE
  );
   CREATE TABLE circle (
       id INT PRIMARY KEY,
       type VARCHAR(255),
       radius DOUBLE
    );
  CREATE TABLE rectangle (
      id INT PRIMARY KEY,
      type VARCHAR(255),
      length DOUBLE,
      width DOUBLE
  );
  CREATE TABLE triangle (
      id INT PRIMARY KEY,
      type VARCHAR(255),
      side1 DOUBLE,
      side2 DOUBLE,
      side3 DOUBLE
  );

  CREATE TABLE drawing (
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(255)
  );
  CREATE TABLE drawing_shapes_list (
  drawing_id INT,
  shapes_list_id INT
  );

-- Shapes
INSERT INTO shape VALUES(1, 'CIRCLE', 650, 430);
INSERT INTO shape VALUES(2, 'RECTANGLE', 200, 150 );
INSERT INTO shape VALUES(3, 'TRIANGLE', 100, 90);
INSERT INTO shape VALUES(4, 'CIRCLE', 80, 120);
INSERT INTO shape VALUES(5, 'RECTANGLE', 120, 250);
INSERT INTO shape VALUES(6, 'CIRCLE', 60, 80);
INSERT INTO shape VALUES(7, 'RECTANGLE', 110, 95);
INSERT INTO shape VALUES(8, 'TRIANGLE', 95, 180);
INSERT INTO shape VALUES(9, 'TRIANGLE', 140, 80);
INSERT INTO shape VALUES(10, 'CIRCLE', 150, 170);



INSERT INTO circle VALUES(1,'circle', 25);
INSERT INTO circle VALUES(4,'circle', 40);
INSERT INTO circle VALUES(6,'circle', 80);
INSERT INTO circle VALUES(10,'circle', 100);


INSERT INTO rectangle VALUES(2,'rectangle', 25, 30);
INSERT INTO rectangle VALUES(5,'rectangle', 50, 60);
INSERT INTO rectangle VALUES(7,'rectangle', 80, 100);


INSERT INTO triangle VALUES(3,'triangle', 8, 6, 4);
INSERT INTO triangle VALUES(8,'triangle', 2, 4, 4);
INSERT INTO triangle VALUES(9,'triangle', 10, 6, 8);


-- drawing
INSERT INTO drawing VALUES(1, 'drawing1');
INSERT INTO drawing VALUES(2, 'drawing2');
INSERT INTO drawing VALUES(3, 'drawing3');


INSERT INTO drawing_shapes_list VALUES(1, 1);
INSERT INTO drawing_shapes_list VALUES(1, 2);
INSERT INTO drawing_shapes_list VALUES(1, 3);


INSERT INTO drawing_shapes_list VALUES(2, 4);
INSERT INTO drawing_shapes_list VALUES(2, 5);
INSERT INTO drawing_shapes_list VALUES(2, 9);



INSERT INTO drawing_shapes_list VALUES(3, 7);
INSERT INTO drawing_shapes_list VALUES(3, 8);
INSERT INTO drawing_shapes_list VALUES(3, 10);





