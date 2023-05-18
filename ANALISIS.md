# Análisis

A medida que una aplicacion aumenta en la cantidad de clientes y las funcionalidades como tal de esta misma, se vuelve importante garantizar que el sistema pueda escalar de manera eficiente y mantenerse al día con la cantidad enorme de demanda.

La estrategia para lograr la escalabilidad en una arquitectura cliente-servidor es el balanceador de carga, esto ayuda a  distribuir la carga de trabajo entre varios servidores para evitar sobrecargar un solo servidor y garantizarle al cliente un rendimiento óptimo de caualquier tipo de aplicación.

Para lograr una mejor escalabilidad se recomienda usar la arquitectura cliente-servidor el cual es el patrón de escalamiento horizontal. El objetivo de esta arquitectura esagregar más instancias de servidor para manejar la carga creciente, en lugar de aumentar los recursos de los servidores individuales.

Por otro lado el rendimiento es un aspecto importante a tener en una cuenta en la arquitectura cliente-servidor debido a que el cliente puede verse afectado en la velocidad en la que el servidor envia una respuesta.

Una posible solucion a este problema de rendimiento es utilizar el almacenamiento en caché. Dado que se pueden pasar los datos y respuestas del servidor esto le permite a los clientes acceder rápidamente a la información solicitada sin tener que volver a consultar el servidor.

Para esta entrega no se hizo uso de almacenamiento en cache, se implementó el patrón Observer el cual se usa para establecer una conexión entre un cliente y un servidor cuando ocurre un evento o un cambio de datos y al cliente se le debería notificar. Esto evita que el cliente tenga que solicitar las actualizaciones que pasan dentro del sistema. Este patrónpermite que el servidor notifique inmediatamente al cliente los cambios que se han hecho en este caso guardar, eliminar y actualizar algún producto o categoria. 

El patrón Observer ayuda a mejorar el rendimiento puesto que reduce la cantidad de solicitudes innecesarias del cliente al servidor. Esto reduce la carga de consultas al servidor y mejora la eficiencia de las conexiones entre el cliente y el servidor.

Se implementa este patrón debido a que con el tiempo, los requisitos y la funcionalidad del sistema pueden cambiar, lo que requiere cambios en la arquitectura cliente/servidor.
Para evitar grandes cambios dentro del codigo la solucion que se le puede dar es utilizar interfaces y dividir la funcionalidad tanto del servidor como del cliente en componentes separados. Esto permite realizar cambios en una determinada parte del sistema sin afectar el funcionamiento de otras partes de la aplicación.

Para mejorar y evitar cambios que dañen el funcionamiento de la aplicación se hace uso del modelo en capas. Al separar el sistema en capas lógicas, como la capa de presentación, la capa de lógica y la capa de datos, se pueden realizar cambios en una capa sin afectar a las otras capas. Esto mejora la escalabilidad y la mantenibilidad del sistema.

En conclusion,  el patrón Observer no afecta directamente el rendimiento en términos de tiempo de respuesta o rendimiento del servidor. Sin embargo, su uso puede mejorar el rendimiento general del sistema al evitar solicitudes innecesarias y aumentar sobrecargas en el servidor. 

Finalmente, es importante tener en cuenta que las decisiones para escoger patrones y arquitecturas específicas del lado del servidor dependen del contexto y los requisitos del sistema, puesto que se puede ver afectado el sen caso de sobrecargas.

# Link del video
[Video compilacion y ejecución](https://youtu.be/DSyxkQpKKKg)