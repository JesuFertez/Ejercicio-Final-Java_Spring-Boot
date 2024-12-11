Dado el siguiente enunciado realice una aplicación con Java y Spring boot.

Una nueva empresa de telefonía requiere un MVP para poder gestionar la información de sus clientes, la oferta de planes que tiene hoy disponible y los contratos que han adquirido sus clientes.

Para resolver dicho problema cree una API Rest que esté al menos en el nivel 2 del Richardson Maturity Model.
Considere que la información del cliente considera los siguientes campos:

Nombre, RUN, Direccion y Fecha de Nacimiento

Los planes consideran lo siguiente:

Nombre del plan, precio y servicios facilitados.

Considere crear una entidad de Contrato para representar la relación de las dos entidades, para esta utilice la información que crea necesaria para el contrato.

Requerimientos:

Listar todos los planes.
Listar todos los clientes, sin el detalle de sus planes.
Listar un cliente con el detalle de sus planes.
Contratar planes.
Desactivar planes.
Desactivar clientes.
Los clientes pueden acceder a descuentos desde el segundo plan que contraten
Considere los test unitarios de la aplicación
Utilice JPA y una base de datos H2 para el desarrollo de la solución

 

Retos adicionales:

Considere la creación de un perfil de administración en la API que está sujeta a algún tipo de autenticación y autorización para poder asignar contratos y dar de baja servicios, y un segundo perfil de super usuario que pueda eliminar información. 

 

Pueden usar la free tier de Mockaroo para generar la data de pruebas.

