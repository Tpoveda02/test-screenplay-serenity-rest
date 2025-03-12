Feature: Obtener peticiones de la seccion mascotas

  Background:
    Given  Un usuario obtiene la baseUrl de la api


  Scenario Outline: Obtener por id (get) los datos que arroja el consumo de la api
    When Configura la petición a consumir con el recurso "<resource>"
    Then debería visualizar el estado de dicha petición
    Examples:
      | resource |
      | pet/2    |
      | pet/1    |


  Scenario Outline: Crear una nueva mascota (post)
    When Configura la petición a consumir con el recurso "pet/" con el cuerpo
      | id   | categoryId | categoryName | name   | photoUrls | tagId   | tagName   | status   |
      | <id> | <catId>    | <catName>    | <name> | <photos>  | <tagId> | <tagName> | <status> |
    Then debería visualizar el estado de dicha petición
    Examples:
      | id | catId | catName | name     | photos   | tagId | tagName  | status    |
      | 1  | 101   | Dogs    | Max      | ["url1"] | 201   | Friendly | available |
      | 2  | 102   | Cats    | Whiskers | ["url2"] | 202   | Playful  | pending   |
      | 3  | 103   | Birds   | Tweety   | ["url3"] | 203   | Cute     | sold      |

  Scenario Outline: Actualizar la información de una mascota (put)
    When Configura la petición a consumir con el recurso "pet/" con el cuerpo para actualizar
      | id   | categoryId | categoryName | name   | photoUrls | tagId   | tagName   | status   |
      | <id> | <catId>    | <catName>    | <name> | <photos>  | <tagId> | <tagName> | <status> |
    Then debería visualizar el estado de dicha petición
    Examples:
      | id | catId | catName | name     | photos   | tagId | tagName  | status |
      | 1  | 101   | Dogs    | Max      | ["url1"] | 201   | Friendly | sold   |
      | 2  | 102   | Cats    | Whiskers | ["url2"] | 202   | Playful  | sold   |
      | 3  | 103   | Birds   | Tweety   | ["url3"] | 203   | Cute     | pending   |