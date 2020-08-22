
INSERT INTO USER (id,name,email,password,last_login,modified,created,is_active) VALUES
  ('63e367fa88e34cb8a02b596c5addbd3b','Manuel','Manuelito@yahoo.com','AAcisco43234','2020-08-20','2020-08-20','2020-08-20',true),
  ('6a658be99a154c808a4db32383996780','Daniela','Danielita@yahoo.com','AAcisco43234','2020-08-20','2020-08-20','2020-08-20',true);

  INSERT INTO PHONE (id,number,city_code,country_code,user_id) VALUES
  ('7e4748cc5b7a4f65a5a99a299eb71376','54645654','56','515','63e367fa88e34cb8a02b596c5addbd3b'),
  ('22a17c331733453e83ff47a80911fc1e','54645654','56','515','6a658be99a154c808a4db32383996780');