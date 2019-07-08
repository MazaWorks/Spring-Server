# Spring Server

Servidor Web que atiende peticiones GET, POST, DELETE sobre la base de datos localhost en el puerto 8080.

## Autor
Maza Espinosa, Jorge Carlos  
Gmail: jorgecarlosmazaespinosa@gmail.com  
GitHub: MazaWorks

### Tecnologias usadas

Este servidor se ha creado usando estas tecnologías:
* Spring Boot: Framework que nos hizo mucho mas sencilla la implementacion de muchas funciones
* Maven: Para construir el proyecto, compilarlo y lanzar el servidor de manera facil
* Java: Lenguaje de programación usado
* Mysql: Sistema de base de datos usado
* MongoDB: Sistema de base de datos usado para los log

### Despliege de la aplicación
Precondicion: Antes de lanzar la aplicación hay que asegurar que se tiene instalado mysql y MongoDB     
Primero instale Docker en su pc.    
Para la instalación de MongoDB, puedes guardar un fichero stack.yml que contenga lo siguiente:

    version: '3.1'
     services:
       mongo:
         image: mongo
         restart: always
         ports:
           - 27017:27017   
         environment:
           MONGO_INITDB_ROOT_USERNAME: root
           MONGO_INITDB_ROOT_PASSWORD: example
    
       mongo-express:   
         image: mongo-express
         restart: always
         ports:
           - 8081:8081
         environment:
           ME_CONFIG_MONGODB_ADMINUSERNAME: root
           ME_CONFIG_MONGODB_ADMINPASSWORD: example

Luego guardas un .bash que tenga los siguientes comandos:  
```sh 
cd /*Ruta donde esta ubicado el fichero stack.yml*/     
docker-compose -f stack.yml up  
PAUSE
```

Antes de lanzar el servidor ejecutamos este .bat
Hay muchas formas de lanzar el servidor.
La primera sería simplemente importar el proyecto y ejecutar el main en el Intellij IDEA y spring boot se encargará del resto.

La otra es mas facil aún, justo en el directorio principal hay un fichero .jar que se puede ejecutar con el comando:
```sh
$ java -jar gs-mysql-data-0.1.0.jar
```
Presionamos Ctrl+C para detener la aplicación

### Estructura interna del servidor

Las clases las hemos dividido en 5 paquetes:

- Controller: Dispone del controlador de la aplicación, el que segun la URL de las peticiones ejecutará un servicio u
otro.

- Dtos: Son clases que almacenan datos que sirven para la comunicación entre el controlador y el servicio.

- Entidades: Clases que almacenan datos que tratan directamente las tablas de la base de datos.

- Servicios: Es el que se encarga de recibir los Dtos y de convertirlos a entidades que son las que representan a las
tablas de la base de datos, y una vez que tenemos la entidad, realizar las distintas operaciones que se quieran hacer
sobre la base de datos. Y al reves, disponiendo de una entidad de la base de datos se encarga de convertirla a Dto para
que el controlador pueda devolverlo.

- Repositorios: Es una interfaz ya implementada por Spring que hace las consultas, o las modificaciones directamente con la base de datos.

- DAOS: Este paquete no hace falta usarlo, solo la clase DAO dentro de este, que tiene una función que permite realizar la consulta: 
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
Dicha consulta es muy dificil realizarla con repositorios asi que la hacemos con un Driver Manager
