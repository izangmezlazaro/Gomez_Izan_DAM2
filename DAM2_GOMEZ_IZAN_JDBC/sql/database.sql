CREATE TABLE laboratorio (
    id              NUMBER(4),
    nombre          VARCHAR2(150),
    pais            VARCHAR2(150),
    autor_examen    VARCHAR2(150),

    CONSTRAINT PK_laboratorio PRIMARY KEY (id),
    CONSTRAINT NN_nombre_laboratorio CHECK (nombre IS NOT NULL),
    CONSTRAINT NN_pais_laboratorio CHECK (pais IS NOT NULL),
    CONSTRAINT NN_autor_examen_laboratorio CHECK (autor_examen IS NOT NULL)
);

CREATE TABLE muestrasADN (
    id                NUMBER(4),
    codigo            VARCHAR2(150),
    tipo              VARCHAR2(150),
    fecha_extraccion  DATE,
    laboratorio_id    NUMBER(4),
    autor_examen      VARCHAR2(150),

    CONSTRAINT PK_muestrasADN PRIMARY KEY (id),
    CONSTRAINT NN_codigo_muestrasADN CHECK (codigo IS NOT NULL),
    CONSTRAINT NN_tipo_muestrasADN CHECK (tipo IS NOT NULL),
    CONSTRAINT NN_laboratorio_id CHECK (laboratorio_id IS NOT NULL),
    CONSTRAINT NN_autor_examen_muestrasADN CHECK (autor_examen IS NOT NULL),
    CONSTRAINT FK_muestrasADN_laboratorio FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id)
);

CREATE TABLE detalle_muestraADN (
    id                        NUMBER(4),
    mutacion_detectada        CHAR(1),
    porcentaje_coincidencia   NUMBER(5,2),
    observaciones             VARCHAR2(150),
    muestraADN_id             NUMBER(4),
    autor_examen              VARCHAR2(150),

    CONSTRAINT PK_detalle_muestraADN PRIMARY KEY (id),
    CONSTRAINT NN_mutacion_detectada CHECK (mutacion_detectada IN ('S','N')),
    CONSTRAINT NN_muestraADN_id CHECK (muestraADN_id IS NOT NULL),
    CONSTRAINT NN_muestraADN_id UNIQUE (muestraADN_id),
    CONSTRAINT NN_autor_examen_detalle CHECK (autor_examen IS NOT NULL),
    CONSTRAINT FK_detalle_muestraADN FOREIGN KEY (muestraADN_id) REFERENCES muestrasADN(id)
);

