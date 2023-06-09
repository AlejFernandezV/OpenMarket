# OpenMarket
<div style="text-align: justify;">

# 1. Desarrollo de un prototipo Open-Market
Como diseñador se le ha solicitado que la aplicación stand-alone desarrollada a lo largo de la clase para OpenMarket y para algunos en el laboratorio, se derive una nueva versión en la que se consideren los siguientes aspectos:

Desde       el punto de vista de la arquitectura se busca que la aplicación mantenga su estructura en capas desde el punto de vista de módulos, pero que ahora permita escalar de un mercado de 100 usuarios a 10.000. Para ello se debe hacer una aplicación cliente-servidor basada en sockets (reutilizar como framework el strategyserver). Los clientes, independiente del sistema operativo, deberían instalar una aplicación cliente que permita acceder a los servicios del servidor.

Del lado del cliente se busca que la arquitectura sea interactiva por lo que debe tener en cuente:

- La actualización continua de las vistas cuando se actualiza la información.

- Tener la posibilidad de hacer y deshacer las acciones de adicionar un producto y eliminar un producto.

- Se debe reutilizar el código brindado en clase, se recomienda implementar una clase RemoteRepository que implemente la interface IRepository y allí programar el código cliente para acceder al servidor. Puede reutilizar todo el código que se requiera del ejemplo TravelAgency. Se debe actualizar el protocolo a conveniencia y hacer uso del formato JSON.

Respecto al servidor se debe:

- Se recomienda reutilizar el código brindado en clase, solo es eliminar el código de la presentación y reemplazarlo por uno nuevo de infraestructura. En este caso en la infraestructura se debe implementar una clase OpenMarketHandler y redefinir los métodos processRequest(...) y respond(...) reutilizando el framework strtategyserver brindado en clase.

- A nivel de instalación se debe instanciar 5 servidores e instanciar un balanceador de carga, los clientes deberán de conectarse al balanceador de carga y el balanceador a las cinco instancias servidoras.

Respecto al balanceador de carga se espera mejorar la política de scheduling de servidores, por ello en primera instancia se busca medir el tiempo promedio de respuesta de los servidores. Es decir, se debe calcular el tiempo que le toma a un servidor entre la recepción de una solicitud y su respuesta. El tiempo promedio de respuesta de un servidor se obtiene calculando la media aritmética de los tiempos de respuesta medidos para cada servidor.

# 2. Entregables
- (1 punto) El código del prototipo del lado del cliente.
- (1 punto) El código del prototipo del lado servidor.
- (0.5 punto) Un video mostrando la compilación y ejecución de la aplicación clienteservidor conectados directamente (sin balanceador de carga).
- (1 punto) La documentación de la arquitectura con UML (diagrama de módulos, diagrama de componentes y conectores y diagrama de instalación). Considerar el balanceador de carga y las 5 instancias del servidor.
- (1 punto) Diagramas de clases y de secuencia UML, tanto del lado del cliente, como del lado del servidor con lo necesario para lograr la eliminación de un producto (es decir hacer la realización del caso de uso eliminar producto).
- (0.5 punto) Realizar un análisis de la solución respecto a los aspectos de la arquitectura. Particularmente considerar los atributos de calidad: escalabilidad, desempeño y modificabilidad. El análisis debe hacerse sobre las decisiones de arquitectura, es decir para cada atributo de calidad enunciado indicar al menos una preocupación que se resuelve (concern), una t actica que se incluye y un patrón de arquitectura que se aplico.
- (0.5 punto Bonus Track) Hacer y probar (video) una nueva implementación del balanceador de carga para medir los tiempos de respuesta haciendo uso de los patrones de diseño método Plantilla y Observador. Debe estar en código y en un diagrama de clases.

# Recursos
1. [Vídeo](https://youtu.be/SRIL2bDUvYU)
2. [Informe Sprint 1](https://docs.google.com/document/d/1EhOfHTtIDdmMCThLIJlvYIdRKFW73Slr2k5g9K85iT4/edit?usp=sharing)
3. [Presentación](https://docs.google.com/presentation/d/1RGfVDltWh2en6S9unhKyw_fHVuepv_bEowY1rmFwb0A/edit?usp=sharing)
</div>