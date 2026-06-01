// ME TOCA USAR INTEGER EN LAS QUE USARIA NUMBER PORQUE NO ME DEJA
   METER NUMBER, SI NO USARIA NUMBER. IGUAL CON EL NUMERIC //



CREATE TABLE laboratorio (
    id             INTEGER,
    nombre          VARCHAR(150),
    pais            VARCHAR(150),
    autor_examen    VARCHAR(150),

    CONSTRAINT PK_laboratorio PRIMARY KEY (id),
    CONSTRAINT NN_nombre_laboratorio CHECK (nombre IS NOT NULL),
    CONSTRAINT NN_pais_laboratorio CHECK (pais IS NOT NULL),
    CONSTRAINT NN_autor_examen_laboratorio CHECK (autor_examen IS NOT NULL)
);


CREATE TABLE muestrasADN (
    id                INTEGER,
    codigo            VARCHAR(150),
    tipo              VARCHAR(150),
    fecha_extraccion  DATE,
    laboratorio_id    INTEGER,
    autor_examen      VARCHAR(150),

    CONSTRAINT PK_muestrasADN PRIMARY KEY (id),
    CONSTRAINT NN_codigo_muestrasADN CHECK (codigo IS NOT NULL),
    CONSTRAINT NN_tipo_muestrasADN CHECK (tipo IS NOT NULL),
    CONSTRAINT NN_laboratorio_id CHECK (laboratorio_id IS NOT NULL),
    CONSTRAINT NN_autor_examen_muestrasADN CHECK (autor_examen IS NOT NULL),
    CONSTRAINT FK_muestrasADN_laboratorio FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id)
);

CREATE TABLE detalle_muestraADN (
    id                      INTEGER,
    mutacion_detectada      CHAR(2),
    porcentaje_coincidencia INTEGER(5,2),
    observaciones           VARCHAR(150),
    muestraADN_id           INTEGER,
    autor_examen            VARCHAR(150),

    CONSTRAINT PK_detalle_muestraADN PRIMARY KEY (id),
    CONSTRAINT CK_mutacion_detectada CHECK (mutacion_detectada IN ('SI', 'NO')),
    CONSTRAINT NN_muestraADN_id CHECK (muestraADN_id IS NOT NULL),
    CONSTRAINT NN_muestraADN_id_uni UNIQUE (muestraADN_id),
    CONSTRAINT NN_autor_examen_detalle CHECK (autor_examen IS NOT NULL),
    CONSTRAINT FK_detalle_muestraADN FOREIGN KEY (muestraADN_id)REFERENCES muestrasADN(id)
);