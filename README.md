# Unidad3 Mykyta Ryasny

Proyecto de clase para conectarse y manipular una BBDD usando hibernate y maven

---

## Tabla de contenidos

- [Uso](#uso)
- [Instalación](#instalacion)
- [Importante BBDD](#Importante)
- [Autor](Autor)

## Uso

La aplicación sirve para conectarse a una base de datos establecida en el archivo de configuracion. Trae diferentes recursos de manipulación de datos.

---

## Instalacion

Para usar la aplicación en caso de tener una base de datos con una configuración acorde al programa hecho se puede ejecutar en el temrinal:

> java -jar EjecutableUd3.jar

En caso de no disponer de una BBDD se ha de usar la aplicación sin compilar y para ello necesitaremos unas herramientas:

1. Java [Descargar](https://www.java.com/en/download/)
2. Un IDE, yo personalmente he usado VScode, pero cualquier IDE es válido, dejo el enlace a Eclipse [Descargar](https://www.eclipse.org/downloads/)
3. Servidor de base de datos. He usado el de MySQL Server [Descargar](https://dev.mysql.com/downloads/mysql/)
4. Workbench para importar datos a la Base de datos [Descargar](https://www.mysql.com/products/workbench/)

Una vez instaladas las herramientas correspondientes se tiene que importar desde Workbench nuestra base de datos, ya sea el model con el archivo Modelo.mwb o el archivo BBDD.sql

<p>

Para ejecutar la aplicación desde eclipse, primero debemos importar y una vez importado nos dirigiremos a nuestro metodo Main y ejecutamos el proyecto.

<p>

En caso de haber creado una BBDD con una configuración diferente a la que viene por defecto, la podemos cambiar en nuestro archivo hibernate.cfg.xml que se encuentra en la carpeta **src/main/java/**

## Importante

- Las 2 tablas que funcionan sin depender de las demás es la tabla Distribuidora y la tabla Productora
- Para poder Insertar un juego tienes que tener datos en Distribuidora y Productora
- Al insertar el juego te pregunta si es on-line para asignarle un servidor, en caso de que sea on-line te pregunta por la capacidad de dicho servidor.
- La asociación de muchos a muchos según mis pruebas no me ha dado problemas, pero no hay muchos metodos por falta de tiempo.
- No se puede borrar el servidor ni mostrar solo servidor por que van asociados a un juego. Un juego no puede dejar de ser online o vovlerse online.
- A la hora de introducir un juego te pregunta cuantas distribuidoras tiene para hacer un bucle.

## Autor

El creador del proyecto es Mykyta Ryasny del grupo 2º Q semi presencial.
