Feature: Requerimiento POST para Crear Usuario

Scenario: Request Creación de usuario correcta
Given El usuario envía el body y los headers para crear un nuevo usuario
When El esquema del jason sea correcto
Then El estado de la solicitud es SC_CREATED