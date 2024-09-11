#language:es
Característica: Creacion de terceros de tipo cliente para el sistema

  Escenario: creacion de un tercero tipo cliente con estado activo
    Dado que se ingresa a pagina siigo como "analista"
    Cuando navegue al menu crear en la opcion "Clientes"
    Y envie la informacion solicitada de manera correcta
    Entonces verifico que el estado del nuevo cliente es "Activo"
