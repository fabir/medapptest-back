CREATE TABLE public.especialidad (
	id_especialidad serial NOT NULL,
	nombre varchar(50) NOT NULL,
	CONSTRAINT especialidad_pkey PRIMARY KEY (id_especialidad)
);

CREATE TABLE public.medico (
	id_medico serial NOT NULL,
	cpf varchar(255) NOT NULL,
	apellidos varchar(255) NOT NULL,
	nombres varchar(255) NOT NULL,
	direccion varchar(255) NOT NULL,
	correo varchar(255) NOT NULL,
	telefono varchar(255) NOT NULL,
	sexo varchar(255) NOT NULL,
	edad int4 NOT NULL,
        id_especialidad int4 NOT NULL,
	CONSTRAINT fk_medico_especialidad FOREIGN KEY (id_especialidad) REFERENCES especialidad(id_especialidad),
	CONSTRAINT medico_pkey PRIMARY KEY (id_medico)
);


CREATE TABLE public.medico_especialidad (
	id_medico int4 NOT NULL,
	id_especialidad int4 NOT NULL,
	CONSTRAINT medico_especialidad_pkey PRIMARY KEY (id_medico, id_especialidad)
);

CREATE TABLE public.paciente (
	id_paciente serial NOT NULL,
	apellidos varchar(255) NULL,
	direccion varchar(255) NULL,
	dni varchar(255) NULL,
	email varchar(255) NULL,
	nombres varchar(255) NULL,
	telefono varchar(255) NULL,
	CONSTRAINT paciente_pkey PRIMARY KEY (id_paciente)
);

CREATE TABLE public.consulta (
	id_consulta serial NOT NULL,
	fecha_consulta timestamp NULL,
	id_especialidad int4 NOT NULL,
	id_medico int4 NOT NULL,
	id_paciente int4 NOT NULL,
	CONSTRAINT consulta_pkey PRIMARY KEY (id_consulta),
	CONSTRAINT fk_consulta_especialidad FOREIGN KEY (id_especialidad) REFERENCES especialidad(id_especialidad),
	CONSTRAINT fk_consulta_medico FOREIGN KEY (id_medico) REFERENCES medico(id_medico),
	CONSTRAINT fk_consulta_paciente FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);

CREATE TABLE public.examen (
	id_examen serial NOT NULL,
	descripcion varchar(150) NULL,
	nombre varchar(50) NOT NULL,
	CONSTRAINT examen_pkey PRIMARY KEY (id_examen)
);

CREATE TABLE public.consulta_examen (
	id_consulta int4 NOT NULL,
	id_examen int4 NOT NULL,
	CONSTRAINT consulta_examen_pkey PRIMARY KEY (id_consulta, id_examen)
);

CREATE TABLE public.detalle_consulta (
	id_det_consulta serial NOT NULL,
	diagnostico varchar(70) NOT NULL,
	tratamiento varchar(300) NOT NULL,
	id_consulta int4 NOT NULL,
	CONSTRAINT detalle_consulta_pkey PRIMARY KEY (id_det_consulta)
);

CREATE TABLE public.menu (
	id_menu int4 NOT NULL,
	nombre varchar(20) NULL,
	url varchar(50) NULL,
	CONSTRAINT menu_pkey PRIMARY KEY (id_menu)
);

CREATE TABLE public.menu_rol (
	id_menu int4 NOT NULL,
	id_rol int4 NOT NULL
);

CREATE TABLE public.rol (
	id_rol serial NOT NULL,
	descripcion varchar(255) NULL,
	nombre varchar(255) NULL,
	CONSTRAINT rol_pkey PRIMARY KEY (id_rol)
);
-- public.menu_rol foreign keys

ALTER TABLE public.menu_rol ADD CONSTRAINT fk8uyjomykqlidw6whr5a9vx16d FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
ALTER TABLE public.menu_rol ADD CONSTRAINT fkjtnyb2364scc8ojb7vwh2jflj FOREIGN KEY (id_rol) REFERENCES rol(id_rol);


CREATE TABLE public.usuario (
	id_usuario int4 NOT NULL,
	activo bool NOT NULL,
	"password" varchar(255) NOT NULL,
	nombre varchar(255) NOT NULL,
	CONSTRAINT uk_cto7dkti4t38iq8r4cqesbd8k UNIQUE (nombre),
	CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
);

CREATE TABLE public.usuario_rol (
	id_usuario int4 NOT NULL,
	id_rol int4 NOT NULL
);


-- public.usuario_rol foreign keys

ALTER TABLE public.usuario_rol ADD CONSTRAINT fk3ftpt75ebughsiy5g03b11akt FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);
ALTER TABLE public.usuario_rol ADD CONSTRAINT fkkxcv7htfnm9x1wkofnud0ewql FOREIGN KEY (id_rol) REFERENCES rol(id_rol);


create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);