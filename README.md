

-----------------------------------------------------
****DESCARGAR EL CODIGO FUENTE DE LA APPLICACION****:
-----------------------------------------------------

Descargar el .zip que ofrece GitHub para la release v3.0 y desde Eclipse hacer "File --> Import --> General --> Projects from Folder or Archive --> Seleccionar la carpeta del proyecto descomprimiuda


----------------------------
****AÑADIR DEPENDENCIAS****:
----------------------------


El submodulo LIB debería resolver sus dependencias automáticamente al pasar un rato debido a que es un Maven project, en caso de que esto no ocurra se puede forzar a actualizar con los siguientes pasos:<br>
  &nbsp;&nbsp;&nbsp;&nbsp;1- Click derecho en el proyecto LIB --> Maven --> Update Project --> OK <br>
  &nbsp;&nbsp;&nbsp;&nbsp;2- Al updatear Maven se cambia el JRE System Library al J2SE1.5, hay que cambiarlo a 1.8:<br>
    Click derecho en LIB --> Build Path --> Configure Build Path --> Libraries --> SELECCIONAR: JRE System Library --> Edit --> Cambiar Execution Enviroment a JavaSE 1.8<br>



----------------------------
****CREAR LA BASE DATOS****:
----------------------------

Para esto es necesario tener MySQL Server operativo en el sistema. Entrar en MySQL y crear una base de datos con el comando -> create database "nombre"; <br>



-----------------------------------------------------
****PASOS PREVIOS ANTES DE LANZAR LA APPLICACION****:
-----------------------------------------------------

En el explorador de proyecto de eclipse ir al proyecto lib -> (carpeta) src/main/java -> (paquete) duolingo.lib.hibernate.util -> (Archivo) "HibernateUtil.java" --> Abrir el archivo y hacer la siguientes modificaciones: <br>

&nbsp;&nbsp;&nbsp;&nbsp;linea 25, [enlace base de datos]: sustituir con tus datos ip, puerto y nombreBaseDatos en "jdbc:mysql://ip:puerto/nombreBaseDatos?serverTimezone=UTC" <br>

&nbsp;&nbsp;&nbsp;&nbsp;linea 26, [usuario]: sustituir "user" en settings.put(Environment.USER, "user"); con el nombre de tu usuario de la base datos. <br>

&nbsp;&nbsp;&nbsp;&nbsp;linea 27, [password]: sustituir "password" en settings.put(Environment.PASS, "password"); con tu password de la base datos. <br>
 
Guardar el fichero al finalizar. <br>



------------------------------
****LANZAR LA APPLICACION****:
------------------------------

En el paquete duolingo.lib.hibernate.test, el fichero "test.java" ofrece la creación y guardado en la BD de varios modelos de ejemplo. Al final del fichero también se utiliza dos ejemplos obteniendo objetos de la BD utilizando DAO
