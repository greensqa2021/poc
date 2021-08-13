@validid
  Feature: Valid ID

    Scenario: An valid id is allowed
      Given Navigate to page BancoPopular
      When A User clicks on popup close
      And A User clicks on persons button
      And A User enter an valid id
      And A User clicks on continue button
      Then Applications show message Escribe tu contrasena
