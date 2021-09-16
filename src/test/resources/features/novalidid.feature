@login
  Feature: Do Login

    @loginValido
    Scenario: login with invalid ID
      Given Navigate to page BancoPopular
      When A User clicks on popup close
      And A User clicks on persons button
      And A User enter an invalid id
      And A User clicks on continue button
      Then Applications show message Algo Salio Mal

    @loginInValido
    Scenario: login with valid ID
      Given Navigate to page BancoPopular
      When A User clicks on popup close
      And A User clicks on persons button
      And A User enter an valid id
      And A User clicks on continue button
      Then Applications show message Escribe tu contrasena


