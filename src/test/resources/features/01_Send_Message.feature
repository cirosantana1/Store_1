# language: es

Característica: Validar  envio de  mensaje por la opción Contacto

  Escenario: Flujo exitoso para el envio de un mensaje
    Dado Que Aron es un usuario que ingresa al portal
    Cuando  Digita la informacion para enviar el mensaje
      | email                | nombre       | mensaje    |
      | email1@gmail.com     | Aron Jimenez | Deseo contactarme con ustedes para el seguimiendo de mi pedido |
    Entonces El sistema le mostrara un mensaje indicando el estado de la transaccion