# practica10

Un grupo de emprendedores de la PUCMM inicia una empresa con una idea innovadora,
la cual tiene como modelo de negocio el alquiler de equipos electrónicos de consumo para
el público en general, el proceso principal consiste en dar de alta a los clientes, tener un
inventario de los equipos y procesar el alquiler de los equipos; el alquiler se completa
cuando todos los elementos alquilados son entregados, la facturación se genera cuando
el cliente va entregando los equipos, el costo a cobrar al cliente depende de la tarifa que
tiene cada uno de los equipos. Dado el escenario planteado realice:


1. El sistema utilizará como motor de base de datos H2, utilizando ORM bajo JPA.
Una vez inicializado el sistema se debe crear un usuario administrador, el cual será
el único que podrá crear usuarios nuevos y asignar roles de permisos a dicho
usuario.
2. El sistema debe permitir administrar los clientes, la cual debe tener la información
básica siendo obligatorio indicar la cédula y la opción de subir una foto del cliente.
3. El sistema debe permitir administrar los equipos que serán alquilados, un equipo
debe ser asociado a una familia y una sub-familia depende de una familia de
equipo. Cada equipo tendrá una cantidad de existencia la cual será controlada en
el proceso de alquiler e indicando el costo por alquiler por día.
4. Para alquilar los equipo, se debe debe registrar la fecha, el cliente, fecha de
promesa de entrega y los equipos. El sistema debe validar que la existencia sea
valida. En el proceso de alquiler se debe poder visualizar la imagen del equipo.
5. El calculo de la facturación será realizada en el momento de la entrega de los
equipos, donde indicará el costo por día de uso. Puede ser que el cliente entregue
de forma parcial los equipos alquilados.
6. El sistema debe mostrar un listado de los equipos alquilados que aun no son
devueltos indicando el cliente y los días alquilados ordenado del alquiler más viejo
al nuevo.
7. Se debe mostrar un historial de alquilares por cliente y un gráfico de promedio de
días alquilado por familia y sub-familia de los equipos.
8. El sistema debe implementar i18n, para dos idiomas mínimo.
9. El sistema debe implementar plantillas basadas en HTML5 y CSS, con capacidad
de web responsiva.
10. El sistema debe implementar Spring Security para el manejo de seguridad.
