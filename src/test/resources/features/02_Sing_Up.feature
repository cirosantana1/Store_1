# language: es

Característica: Validar el registro de un cliente

  Escenario: Flujo exitoso para el registro de un cliente en el portal
    Dado Que Aldredo es un usuario que ingresa al portal
    Cuando  Digita la informacion para registrarse
      | nombre           | password     |
      | Alfredo70        | 00000        |
    Entonces El sistema le mostrara un mensaje exitoso