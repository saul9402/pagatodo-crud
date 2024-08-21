1. Para ejecutar el proyecto se deberá descargar la rama master o clonar el proyecto.
2. Si se desea se puede compilar con mvnw, usando los comandos ./mvnw clean y ./mvnw build. Esto generará el archivo .jar ejecutable
3. Dicho -jar se encontrá en la carpeta target con el nombre crud-0.0.1-SNAPSHOT.jar, este se deberá ejecutar con el siguiente comando java -jar crud-0.0.1-SNAPSHOT.jar -Dspring-profiles.active=[postgres | db2]
4. Se debe escoger entre los valores postgres y db2, dependiendo el que se elija será la BD que usará
5. (Como prerequisito se mecesita tener los servidores de BD para postgres y DB2 instalados y corriendo en los puertos 5432 y 25000 respectivamente con el usuario postgres y db2, según sea el caso y la password root para ambos casos)
6. En caso de necesitar cambiar el usuario, password, host, puerto o bd a utilizar será necesario realizar el cambio sobre los application.yml correspondientes y realizar el procedimiento del paso 2.
7. Una vez cumplidos les requisitos y ejecutado el paso 3 se deberán ejecutar los scripts encontrados en la ruta src/resources/databases. Hay un archivo para postgres y otro para DB2 se deberá ejecutar en su respectiva plataforma según el nombre del archivo.
8. Una vez que todo se ha ejecutado correctamente se deberá hacer uso de la colección pagatodo-crud.postman_collection.json y pagatodo-env.postman_environment.json importandolas en postman.
9. Se encontrarán dos carpetas una para empleados y una para departamentos con las cuales se pueden realizar todas las operaciones de CRUD solicitadas.
10. Ya se tiene un usuario y contraseña configurados en la carptea raíz de la colección, el cual es user = admin; pass = 456 con rol = USER, ADMIN. Este usuario cuenta con todos los privilegios para realizar todo tipo de operaciones.
11. Existen dos usuarios más con ls que se puede acceder al CRUD los cuales son user = spamer; pass = 123; role = ADMIN y user = savila; pass = savila; role = USER.

