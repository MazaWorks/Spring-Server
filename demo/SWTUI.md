# SWT USER INTERFACE

Interfaz gráfica en JAVA usando Standard Widget Toolkit (SWT) que permite añadir, editar, borrar 
entradas para la tabla sedeJJOO de una base de datos local, además de realizar una consulta SQL
específica que aparece mas abajo

## Autor

Maza Espinosa, Jorge Carlos  
Gmail: jorgecarlosmazaespinosa@gmail.com  
Github: MazaWorks

### Tecnologias usadas

Este servidor se ha creado usando estas tecnologías:
* Spring Boot: Framework que nos hizo mucho mas sencilla la implementacion de muchas funciones
* SWT: Conjunto de componentes para construir interfaces gráficas en Java, (widgets)
* Maven: Para construir el proyecto, compilarlo y lanzar el servidor de manera facil
* Java: Lenguaje de programación usado
* Mysql: Sistema de base de datos usado
* MongoDB: Sistema de base de datos usado para los log

### Despliege de la aplicación

Precondicion: Antes de lanzar la aplicación hay que asegurar que se tiene instalado mysql.    

Hay muchas formas de lanzar el servidor.
La primera sería simplemente importar el proyecto y ejecutar el main en el Intellij IDEA y spring boot se encargará del resto.

La otra es mas facil aún, justo en el directorio principal hay un fichero .jar que se puede ejecutar con el comando:
```sh
$ java -jar gs-mysql-data-0.1.0.jar
```
Presionamos Ctrl+C para detener la aplicación

Una vez tengamos el servidor funcionando damos doble click en el archivo SwtQindel.jar que nos abrirá la aplicación

### Uso de la interfaz

Lo primero que nos lanza es una pantalla dos botones que nos darán las dos funcionalidades, consulta y sedeJJOO(CRUD).
La opción consulta nos permite ver el resultado de esta sentencia SQL:
```sh
(SELECT P.id_pais, P.nombre_pais, C.id_ciudad, C.nombre_ciudad, IFNULL(C.valor_ciudad,P.valor_pais) AS valor,
CASE
    WHEN C.id_ciudad = S.sede THEN T.descripcion_tipo
    ELSE "NULL"
END as descripcion_tipo, count(DISTINCT S.año) as veces_sede
FROM pais P, tipo_jjoo T, Ciudad C 
LEFT JOIN sede_jjoo S ON C.id_ciudad = S.sede
WHERE P.id_pais = C.id_pais 
group by C.id_ciudad;)
```

La opción sedeJJOO nos presenta la tabla sedeJJOO y nos da las opciones ADD, EDIT Y DELETE.  
Para editar y eliminar simplemente escogemos las tuplas que queremos editar o eliminar y marcamos la opcion deseada.
En el caso de editar se nos abrirá otra ventana con las ciudades por las que podemos editar. Al eliminar se nos abrirá una 
ventana para asegurar la respuesta.  
Si presionamos añadir se nos abrirá un formulario con los campos que hay que introducir, tendremos ademas las opciones de añadir ciudad
y la de añadir pais, que nos permitiría añadir paises y ciudades para la nueva sede.  
Los problemas y exepciones saldrán por pantalla en modo de una ventana con un boton en el que se muestra el problema

### Estructura interna

Tenemos 3 paquetes principales:

- MainClass: Dispone del main, simplemente es una pantalla con 2 botonos para las 2 funcionalidades qeu deberíamos tener
, la consulta SQL y el CRUD de la tabla Sede_JJOO

- Eventos: Hay dos eventos principales, el que se ejecuta con los botones de la pantalla principal (MainButtonEvents) y el que se ejecuta tras presionar
los botones ADD o EDIT (PostEvents). Estos ultimos presentan formularios a rellenar para la modificación de la base de datos

- Peticiones: Es el que realiza las peticiones GET | POST | DELETE. Se le pasa una url y en el caso del POST, un json. En el
caso del GET returna un string con el json que devuelve