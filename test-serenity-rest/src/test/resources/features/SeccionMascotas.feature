Feature: Ordenar productos y realizar una compra en Swag Labs

  Background:
    Given  Un usuario obtiene la baseUrl de la api


  Scenario Outline: Obtener (get) los datos que arroja el consumo de la api 
    When Configura la petición a consumir con el recurso "<resource>"
    Then debería visualizar el estado de dicha petición 

    Examples:
      |resource|
      |store/inventory|

  
