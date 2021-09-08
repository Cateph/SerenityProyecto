Feature: Request Creación de usuario correcta

  Scenario Outline: Validar body
    Given El usuario envía el "<name>" y el "<job>" del usuario a actualizar
    When Se accede a la "<url>" de la api
    And Se valida el esquema json sea correcto
    Then El estado de la solicitud update es SC_OK
    Examples:
      | name     |  job          | url                         |
      | morpheus | leader        | https://reqres.in/api/users |


