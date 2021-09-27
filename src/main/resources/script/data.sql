
INSERT INTO public.usuario(id_usuario, activo, "password", nombre)
VALUES(1, true, '$2a$10$ydmM/jZ4Hwi3BkHqMlEREOH.N7/XOROn890vwPv3PBAy3T2yP9qsW', 'admin');
INSERT INTO public.usuario(id_usuario, activo, "password", nombre)
VALUES(2, true, '$2a$10$ydmM/jZ4Hwi3BkHqMlEREOH.N7/XOROn890vwPv3PBAy3T2yP9qsW', 'paciente');
INSERT INTO public.usuario(id_usuario, activo, "password", nombre)
VALUES(3, true, '$2a$10$ydmM/jZ4Hwi3BkHqMlEREOH.N7/XOROn890vwPv3PBAy3T2yP9qsW', 'medico');

INSERT INTO Rol (id_rol, nombre, descripcion) VALUES (1, 'ADMIN', 'Administrador');
INSERT INTO Rol (id_rol, nombre, descripcion) VALUES (2, 'PACIENTE', 'Paciente');
INSERT INTO Rol (id_rol, nombre, descripcion) VALUES (3, 'MEDICO', 'Medico');

INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (3, 3);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);


INSERT INTO menu(id_menu, nombre, url) VALUES (1, 'Consultas', '/consulta');
INSERT INTO menu(id_menu, nombre, url) VALUES (2, 'Especialidades', '/especialidad');
INSERT INTO menu(id_menu, nombre, url) VALUES (3, 'Médicos', '/medico');
INSERT INTO menu(id_menu, nombre, url) VALUES (4, 'Examenes', '/examen');
INSERT INTO menu(id_menu, nombre, url) VALUES (5, 'Pacientes', '/paciente');
INSERT INTO menu(id_menu, nombre, url) VALUES (6, 'Reportes', '/reporte');


INSERT INTO menu_rol (id_menu, id_rol) VALUES (1, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (2, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (3, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (4, 1);
INSERT INTO menu_rol (id_menu, id_rol) VALUES (5, 1);

INSERT INTO menu_rol (id_menu, id_rol) VALUES (6, 2);

INSERT INTO menu_rol (id_menu, id_rol) VALUES (1, 3);

INSERT INTO especialidad(nombre)VALUES('Clinico');
INSERT INTO especialidad(nombre)VALUES('Oftalmologia');
INSERT INTO especialidad(nombre)VALUES('Cardiologia');


INSERT INTO public.examen(descripcion, nombre)
VALUES('Análisis de Sangre', 'Análisis de Sangre');
INSERT INTO public.examen(descripcion, nombre)
VALUES('Hemoglobina', 'Hemoglobina');
INSERT INTO public.examen(descripcion, nombre)
VALUES('Plaquetas', 'Plaquetas');


INSERT INTO public.paciente(apellidos, direccion, dni, email, nombres, telefono)
VALUES('Gomez', 'molas lopez 123', '1203514', 'mgomez@mediapp.com', 'Marcos', '123258');
INSERT INTO public.paciente(apellidos, direccion, dni, email, nombres, telefono)
VALUES('Rodriguez', 'Laureles 1554', '5147320', 'jrodriguez@mediapp.com', 'Jorge', '258741');
INSERT INTO public.paciente(apellidos, direccion, dni, email, nombres, telefono)
VALUES('Ferreira', 'villa morra 657', '8203154', 'eferreira@mediapp.com', 'Emilia', '369201');


INSERT INTO public.medico
(cpf, apellidos, nombres, direccion, correo, telefono, sexo, edad, id_especialidad)
VALUES('562', 'Barboza', 'Enrique', 'pascua 234', 'ebarboza@medapp.com', '021458745', 'M', 35, 1);
INSERT INTO public.medico
(cpf, apellidos, nombres, direccion, correo, telefono, sexo, edad, id_especialidad)
VALUES('864', 'Perez', 'Rodrigo', 'moracue 115', 'rperez@medapp.com', '992365478', 'M', 60, 2);

