@novalidid
  Feature: No valid ID

    Scenario: An invalid id is allowed
      Given Navigate to page BancoPopular
      When A User clicks on popup close
      And A User clicks on persons button
      And A User enter an invalid id
      And A User clicks on continue button
      Then Applications show message Algo Salio Mal
