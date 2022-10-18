INSERT INTO authority (id,authority) VALUES (1,"ROLE_ADMIN");
INSERT INTO authority (id,authority) VALUES (2,"ROLE_USER");

INSERT INTO usuarios (id,apellido1,apellido2,cedula,contrasena,email,enabled,nombre) VALUES (1,"Apellido 1","Apellido 2",0,"$2a$04$DzS3f9SGnRuwf99NlX6E/emuIQjNVOaU4h8nX3KNGc49sHFrd562C","admin@gmail.com",b'1',"Nombre");
INSERT INTO usuarios (id,apellido1,apellido2,cedula,contrasena,email,enabled,nombre) VALUES (2,'Apellido 1','Apellido 2',1,'$2a$04$wRzLtGKfe0LulL4UO73n2eexgGRROXcLiF8MPjWLGoEKqi6c3dPDa','user@gmail.com', b'1','Nombre');
INSERT INTO authorities_users (usuario_id,authority_id) VALUES (1,1);
INSERT INTO authorities_users (usuario_id,authority_id) VALUES (2,2);
