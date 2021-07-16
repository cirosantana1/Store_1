# language: es

Característica: Validar autenticacion de un cliente

  Escenario: Flujo exitoso para autenticar a un cliente en el portal
    Dado Que Alfredo es un usuario que ingresa al portal
    Cuando  Digita la informacion para autenticarse
      | nombre           | password     |
      | Alfredo70        | 00000        |
    Entonces El sistema le mostrara un mensaje exitoso al autenticarse