# Mercado-Libre-Challenge  :information_source:



# MERCADOLIBRE MOBILE CANDIDATE :iphone:

Se realizo dicha aplicación para demostrar los conocimientos y experienca en Desarrollo Móvil de mi persona como parte del proceso de selección a una vacante en la prestigiosa empresa Mercado Libre, en Colombia, para poder formar parte de su gran equipo de trabajo. El lenguaje de Programación que se utilizo fue Java. 


# Descripción Técnica :clipboard:

Se desarrollo la aplicación en el lenguaje de programación Java, con la herramienta de trabajo Android Studio, siguiendo los lineamientos en los layout de Material Design (MDC). 

La aplicación consta de:
* Tres Activities, uno para cada pantalla solicitada en el Challenge.
* Un Adaptador, para la lista de los resultados de la busqueda.
* Una Interfaz, la cual sera la encargada de controlar el click de cada item de la consulta.
* Se crearon dos AsynTask, uno para la consulta de sugerencias y otro interno para la consulta de los productos.
* Se crearon tres clases como utilidades para mejor fluidez del código.
* Se crearon varios modelos, que son correspondientes a la respuesta del API con endpoint `/sites/MCO/search?q=query`


## Patron de Diseño :exclamation:

Se utilizo el Patrón de diseño Modelo, Vista y Controlador (MVC), donde un modelo es de tipo DBMODEL para guardar las sugerencias del usuario al realizar las busquedas.

### Pantalla Busqueda :mag_right:

La primera pantalla solicitada en el challenge que funcionara como buscador, se realizo de una manera sencilla, por motivos que se ha decidido por cuestiones de tiempo sea la pantalla principal luego del Splash, se completo la vista con datos de contacos personales de mi persona el candidato a la vacante, Se desarrollo un SearchView que suministrara sugerencias al usuario, por motivos que no en los endpoints suministrados no exisitia uno en especifico para sugerencia y se decidio darle ese valor agregado, se consulta el mismo endpoint de la busqueda, y se van tomando los titulos del JSON respuesta.

### Pantalla Resultados :scroll:

Se desarrollo esta pantalla con un RecyclerView para mostrar los resultados al consultar mediante el query el endpoint mencionado anteriormente. Esta actividad se implemento un Listener que es pasado como parametro al Adaptador del recyclerView el cual sera encargado de controlar el  evento de click sobre cada item del recyclerview el cual nos desplazará a la actividad del detalle tras una pequeña animación de transición que se decidio colocar como valor agregado.

### Pantalal Detalle :memo:

Se desarrollo esta pantalla mostrando un diseño simple con la imagen suministrada por el Endpoint mencionado, y un breve detalle de los datos relevantes del producto.




