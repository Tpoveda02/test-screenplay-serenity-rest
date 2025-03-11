Feature: Obtener peticiones de la seccion mascotas

  Background:
    Given  Un usuario obtiene la baseUrl de la api


  Scenario Outline: Obtener por id (get) los datos que arroja el consumo de la api
    When Configura la petición a consumir con el recurso "<resource>"
    Then debería visualizar el estado de dicha petición 

    Examples:
      |resource|
      |pet/2|
      |pet/1|

  
