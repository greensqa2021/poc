package BancoPopular;

import Utils.Configuracion;
import Utils.FunctionalMonitoring;
import Utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Stopwatch;
import com.greensqa.zapiconsumer.ZephyrClient;
import com.greensqa.zapiutil.dto.Status;
import com.greensqa.zapiutil.dto.TestCaseExecution;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;


public class Steps {
    private WebDriver driver;
    private Stopwatch stopwatch;
    private Boolean result;
    private String robotName;

    @BeforeAll
    public static void setup() {
        System.out.println("INICIO TIEMPO");
    }

    @AfterAll
    public static void teardown() {
        System.out.println("FIN TIEMPO");
    }


    @Before
    public void setUp() {
        Configuracion.iniciarConfiguracion();
        Configuracion.iniciarZapiClientV1();
        stopwatch = Stopwatch.createStarted();
        result = false;
        System.out.println("INICIO TIEMPO");
    }
    @After
    public void tearDown() {

        if (Configuracion.driver!=null) {
            Configuracion.driver.close();
            Configuracion.driver.quit();
        }
        stopwatch.stop();
        long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("tiempo: " + millis);
        FunctionalMonitoring.publish(25000, 35000, millis, result, robotName);
    }

    @Given("Navigate to page BancoPopular")
    public void navigateToPageBancoPopular() {
        Configuracion.driver.navigate().to("https://www.bancopopular.com.co/");
    }

    @When("A User clicks on popup close")
    public void aUserClicksOnPopupClose() {
        Configuracion.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div/section/div[2]/div/div/a")).click();
    }

    @When("A User clicks on persons button")
    public void aUserClicksOnPersonsButton() {
        Configuracion.driver.findElement(By.id("newbp-mp-zona-transaccional-personas")).click();
    }

    @And("A User enter an invalid id")
    public void aUserEntersAnInvalidId() {


        ArrayList<String> tabs2 = new ArrayList<String> (Configuracion.driver.getWindowHandles());
        Configuracion.driver.switchTo().window(tabs2.get(1));
        Configuracion.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).click();
        Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).sendKeys("1233211232");
    }

    @And("A User clicks on continue button")
    public void aUserClicksOnContinueButton() {
        Configuracion.driver.findElement(By.id("btn_login")).click();
    }

    @Then("Applications show message Algo Salio Mal")
    public void applicationShowsMessageAlgoSalioMal() throws JsonProcessingException {
      try {
          String actualMessage = Utilities.esperarElemento("//h4[contains(text(),'Algo')]", "xpath", 15).getText();
          TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(Configuracion.zcv1, 10000, 10016, 10001, "-1");
          robotName = "BotPocPopular_LoginInvalido";
          if ((actualMessage.substring(1, 5)).equals("Algo")) {
              System.out.println("CASO OK");
              result = true;
              ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getPassStatus(), "Prueba OK");
          } else {
              System.out.println("CASO FALLIDO");
              ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getFailStatus(), "No se encontro el texto algo salio mal");

          }
          MatcherAssert.assertThat((actualMessage.substring(1, 5)), is("Algo"));
      }catch (Exception e){
          TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(Configuracion.zcv1, 10000, 10016, 10001, "-1");
          robotName="BotPocPopular_LoginInvalido";
          ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getFailStatus(), "Se produjo un error de ambiente");
          System.out.println("error de ambiente");
      }

    }

    @And("A User enter an valid id")
    public void aUserEntersAnValidId() {
        ArrayList<String> tabs2 = new ArrayList<String> (Configuracion.driver.getWindowHandles());
        Configuracion.driver.switchTo().window(tabs2.get(1));
        Configuracion.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).click();
        Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).sendKeys("3012602");
    }

    @Then("Applications show message Escribe tu contrasena")
    public void applicationShowsMessageEscribeTuContrasena() throws JsonProcessingException {

        try {
            String actualMessage =  Utilities.esperarElemento("//h4[contains(text(),'Escribe')]","xpath",15).getText();
            TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(Configuracion.zcv1, 10000, 10017, 10001, "-1");
            robotName="BotPocPopular_LoginValido";
            if ((actualMessage.substring(0, 7)).equals("Escribe")) {

                System.out.println("CASO OK");
                result = true;
                ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getPassStatus(), "Prueba OK");
            } else {
                ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getFailStatus(), "No se encontro el texto escribe la contraseña");
                System.out.println("CASO FALLIDO");
            }

            MatcherAssert.assertThat ((actualMessage.substring(0, 7)), is("Escribe"));
        }catch (Exception e){
            TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(Configuracion.zcv1, 10000, 10017, 10001, "-1");
            robotName="BotPocPopular_LoginValido";
            ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getFailStatus(), "Se produjo un error de ambiente");
            System.out.println("error de ambiente");
        }




    }

}
