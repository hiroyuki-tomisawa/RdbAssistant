CREATE TABLE ANIMALS(ID INTEGER PRIMARY KEY,ORDO TEXT,SIMPLE_NAME TEXT,UPDATE_TIME TEXT);
CREATE TABLE ANIMALS_DETAIL(ID INTEGER PRIMARY KEY,ANIMALS_ID INTEGER,NAME TEXT,ORIGIN TEXT,UPDATE_TIME TEXT);
CREATE TABLE ANIMALS_DETAIL2(ID INTEGER PRIMARY KEY,ANIMALS_ID INTEGER,NAME TEXT,ORIGIN TEXT,UPDATE_TIME TEXT);

INSERT INTO ANIMALS VALUES ('1','CARNIVRA','CAT','2009/07/19 15:24:32');
INSERT INTO ANIMALS VALUES ('2','CARNIVRA','DOG','2009/07/20 12:22:34');
INSERT INTO ANIMALS_DETAIL VALUES ('1','1','Abyssinian','UNKNOWN','2009/07/19 15:30:11');
INSERT INTO ANIMALS_DETAIL VALUES ('2','1','American Shorthair ','United States','2009/07/19 15:31:21');
INSERT INTO ANIMALS_DETAIL VALUES ('3','1','Japanese Bobtail','Japan','2009/07/19 15:31:52');
INSERT INTO ANIMALS_DETAIL VALUES ('4','1','Maine Coon','United States','2009/07/19 15:32:32');
INSERT INTO ANIMALS_DETAIL VALUES ('5','2','Shiba Inu','Japan','2009/07/20 13:01:19');
INSERT INTO ANIMALS_DETAIL VALUES ('6','2','Chihuahua','México','2009/07/20 13:01:19');
INSERT INTO ANIMALS_DETAIL VALUES ('7','2','Akita Inu','Japan','2009/07/20 13:01:19');

INSERT INTO ANIMALS_DETAIL2 VALUES ('1','1','Abyssinian','UNKNOWN','2009/07/19 15:30:11');
INSERT INTO ANIMALS_DETAIL2 VALUES ('2','1','American Shorthair ','America','2009/07/19 15:31:21');
INSERT INTO ANIMALS_DETAIL2 VALUES ('3','1','Japanese Bobtail','Japan','2009/07/19 15:31:52');
INSERT INTO ANIMALS_DETAIL2 VALUES ('5','2','Shiba Inu','Japan','2009/07/20 13:01:19');
INSERT INTO ANIMALS_DETAIL2 VALUES ('6','2','Chihuahua','México','2009/07/20 13:01:19');
INSERT INTO ANIMALS_DETAIL2 VALUES ('7','2','Akita Inu','Japan','2009/07/20 13:01:19');
INSERT INTO ANIMALS_DETAIL2 VALUES ('8','2','Golden Retriever','Scotland','2009/07/20 13:21:52');
