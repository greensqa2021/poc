$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/novalidid.feature");
formatter.feature({
  "name": "Do Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "login with invalid ID",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to page BancoPopular",
  "keyword": "Given "
});
formatter.match({
  "location": "BancoPopular.Steps.navigateToPageBancoPopular()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on popup close",
  "keyword": "When "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserClicksOnPopupClose()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on persons button",
  "keyword": "And "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserClicksOnPersonsButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User enter an invalid id",
  "keyword": "And "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserEntersAnInvalidId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on continue button",
  "keyword": "And "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserClicksOnContinueButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Applications show message Algo Salio Mal",
  "keyword": "Then "
});
formatter.match({
  "location": "BancoPopular.Steps.applicationShowsMessageAlgoSalioMal()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "login with valid ID",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to page BancoPopular",
  "keyword": "Given "
});
formatter.match({
  "location": "BancoPopular.Steps.navigateToPageBancoPopular()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on popup close",
  "keyword": "When "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserClicksOnPopupClose()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on persons button",
  "keyword": "And "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserClicksOnPersonsButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User enter an valid id",
  "keyword": "And "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserEntersAnValidId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on continue button",
  "keyword": "And "
});
formatter.match({
  "location": "BancoPopular.Steps.aUserClicksOnContinueButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Applications show message Escribe tu contrasena",
  "keyword": "Then "
});
formatter.match({
  "location": "BancoPopular.Steps.applicationShowsMessageEscribeTuContrasena()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});