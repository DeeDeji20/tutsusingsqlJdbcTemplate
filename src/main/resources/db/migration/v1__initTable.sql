 CREATE TABLE tutorial (
     id BIGINT PRIMARY  KEY NOT NULL AUTO_INCREMENT,
     title TEXT NOT NULL,
     description TEXT NOT NULL ,
     level INT NOT NULL     ,
     published BOOLEAN NOT NULL ,
     created DATE NOT NULL,
     unique(title)
 );