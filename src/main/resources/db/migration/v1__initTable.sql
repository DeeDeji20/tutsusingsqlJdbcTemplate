 CREATE TABLE tutorial (
     id BIGSERIAL PRIMARY  KEY,
     title TEXT NOT NULL,
     description TEXT NOT NULL ,
     level INT NOT NULL     ,
     published BOOLEAN NOT NULL ,
     created DATE NOT NULL,
     unique(title  )
 );