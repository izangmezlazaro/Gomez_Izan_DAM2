PREGUNTAS OBLIGATORIAS

El alumno deberá responder digitalmente en:

RESPUESTAS_APELLIDO_NOMBRE.md

PREGUNTA 1

Explica cómo funciona la relación 1:N entre Laboratorio y MuestraADN tanto en SQL como en Java.

-En SQL la relacion 1:N funciona con una foreign key, en este caso un laboratorio puede tener multiples muestras de adn pero una muestra de adn no puede tener muchos laboratorios. En este caso en la tabla "N" que seria MUESTRAS_ADN se colocaria el ID de laboratorios como FK.

En Java esta relacion funciona con un parametro dentro del .java que sea la relacion "N" , en este caso el MuestraADN.java, en este se colocaria el parametro private Laboratorio idLaboratorio colocando el objeto dentro de la relacion para poder realizarla perfectamente, luego ya entraria de por medio el DAO para futuros aspectos.

PREGUNTA 2

Explica por qué en Java utilizamos:

private Laboratorio agencia;

y no:

private int laboratorioId;

-Pues usamos eso para realizar las relaciones, se usa en la tabla de N en una relacion 1:N , si se usar el otro no hay forma de que se relacione. Tambien encapsula toda la info relacionada en un unico objeto y permite que navegacion.

PREGUNTA 3

Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente.


- El PreparedStatement tiene una ventaja mayor a conectar SQL manualmente por varios motivos, uno de estos es la seguridad. 
Usando el preparedstatement en vez de SQL manual permite que nos
protegamos de la inyeccion SQL asi nuestros datos quedan mas protegidos y ocultos a modificaciones maliciosas.
También porque una vez que compila el sistema esa sentencia SQL lo unico que hace es editar las variables que estan en "?" por lo tanto no hay tantas sentencias y se puede reutilizar mas codigo, es decir que mejor rendimiento.

