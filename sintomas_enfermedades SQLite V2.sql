--==============================================================
-- DBMS name:      ANSI Level 2
-- Created on:     26/11/2020 10:54:26
--==============================================================


drop index CONEXION_INTERNET_PK;

drop table CONEXION_INTERNET cascade;

drop index CONSULTAS_HECHAS_PK;

drop table CONSULTAS_HECHAS cascade;

drop index ENFERMEDAD_PK;

drop table ENFERMEDAD cascade;

drop index RELATIONSHIP_1_FK;

drop index RELATIONSHIP_3_FK;

drop index ENFERMEDAD_SINTOMA_PK;

drop table ENFERMEDAD_SINTOMA cascade;

drop index PREGUNTAS_PK;

drop table PREGUNTAS cascade;

drop index SINTOMAS_PK;

drop table SINTOMAS cascade;

--==============================================================
-- Table: CONEXION_INTERNET
--==============================================================
create table CONEXION_INTERNET (
ID_CONEXION          NUMERIC(6)           not null,
ULTIMA_FECHA_CONN    DATE,
ESTAOD_CONEXION      smallint,
primary key (ID_CONEXION)
);

--==============================================================
-- Index: CONEXION_INTERNET_PK
--==============================================================
create unique index CONEXION_INTERNET_PK on CONEXION_INTERNET (
ID_CONEXION ASC
);

--==============================================================
-- Table: CONSULTAS_HECHAS
--==============================================================
create table CONSULTAS_HECHAS (
ID_CONSULTA          NUMERIC(6)           not null,
SEXO_USUARIO         VARCHAR(20),
EDAD_USUARIO         INTEGER,
IMEI_USUARIO         VARCHAR(30),
LUGAR_USUARIO        VARCHAR(150),
SINTOMA_UNO          VARCHAR(50),
SINTOMA_DOS          VARCHAR(150),
SINTOMA_TRES         VARCHAR(100),
SINTOMA_CUATRO       VARCHAR(100),
SINTOMA_CINCO        VARCHAR(100),
SINTOMA_SEIS         VARCHAR(100),
SINTOMA_SIETE        VARCHAR(100),
SINTOMA_OCHO         VARCHAR(100),
SINTOMA_NUEVE        VARCHAR(100),
SINTOMA_DIES         VARCHAR(100),
DIAG_UNO             VARCHAR(1000),
DIAG_DOS             VARCHAR(100),
DIAG_TRES            VARCHAR(100),
HORA_CONSULTA        DATE,
primary key (ID_CONSULTA)
);

--==============================================================
-- Index: CONSULTAS_HECHAS_PK
--==============================================================
create unique index CONSULTAS_HECHAS_PK on CONSULTAS_HECHAS (
ID_CONSULTA ASC
);

--==============================================================
-- Table: ENFERMEDAD
--==============================================================
create table ENFERMEDAD (
ID_ENFERMEDADES      NUMERIC(6)           not null,
NOMBRE_ENFERMEDAD    VARCHAR(200),
DESCRIPCION_ENFERMEDAD CHAR(254),
TRATAMIENTO_ENFERMEDAD CHAR(254),
primary key (ID_ENFERMEDADES)
);

--==============================================================
-- Index: ENFERMEDAD_PK
--==============================================================
create unique index ENFERMEDAD_PK on ENFERMEDAD (
ID_ENFERMEDADES ASC
);

--==============================================================
-- Table: SINTOMAS
--==============================================================
create table SINTOMAS (
ID_SINTOMA           NUMERIC(6)           not null,
NOMBRE_SINTOMA       VARCHAR(100),
primary key (ID_SINTOMA)
);

--==============================================================
-- Table: ENFERMEDAD_SINTOMA
--==============================================================
create table ENFERMEDAD_SINTOMA (
ID_SINTOMA           INTEGER              not null,
ID_ENFERMEDADES      INTEGER              not null,
PRIORIDAD_SINTOMA    INTEGER,
primary key (ID_SINTOMA, ID_ENFERMEDADES),
foreign key (ID_ENFERMEDADES)
      references ENFERMEDAD (ID_ENFERMEDADES),
foreign key (ID_SINTOMA)
      references SINTOMAS (ID_SINTOMA)
);

--==============================================================
-- Index: ENFERMEDAD_SINTOMA_PK
--==============================================================
create unique index ENFERMEDAD_SINTOMA_PK on ENFERMEDAD_SINTOMA (
ID_SINTOMA ASC,
ID_ENFERMEDADES ASC
);

--==============================================================
-- Index: RELATIONSHIP_3_FK
--==============================================================
create  index RELATIONSHIP_3_FK on ENFERMEDAD_SINTOMA (
ID_ENFERMEDADES ASC
);

--==============================================================
-- Index: RELATIONSHIP_1_FK
--==============================================================
create  index RELATIONSHIP_1_FK on ENFERMEDAD_SINTOMA (
ID_SINTOMA ASC
);

--==============================================================
-- Table: PREGUNTAS
--==============================================================
create table PREGUNTAS (
ID_PREGUNTAS         NUMERIC(6)           not null,
PREGUNTA_ENF         CHAR(254),
ESTADO               CHAR(254),
RESPUESTA_PREG       CHAR(254),
primary key (ID_PREGUNTAS)
);

--==============================================================
-- Index: PREGUNTAS_PK
--==============================================================
create unique index PREGUNTAS_PK on PREGUNTAS (
ID_PREGUNTAS ASC
);

--==============================================================
-- Index: SINTOMAS_PK
--==============================================================
create unique index SINTOMAS_PK on SINTOMAS (
ID_SINTOMA ASC
);

