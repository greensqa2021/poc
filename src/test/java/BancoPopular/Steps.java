package BancoPopular;

import Utils.Configuracion;
import Utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    @Before
    public void setUp() {
        Configuracion.iniciarConfiguracion();
        Configuracion.iniciarZapiClientV1();

    }
    @After
    public void tearDown() {

        if (Configuracion.driver!=null) {
            Configuracion.driver.close();
            Configuracion.driver.quit();
        }
    }

    @Given("Navigate to page BancoPopular")
    public void navigateToPageBancoPopular() {
        Configuracion.driver.navigate().to("https://www.bancopopular.com.co/");
    }

    @When("A User clicks on popup close")
    public void aUserClicksOnPopupClose() {
        Configuracion.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div/section/div[2]/div/div/a")).click();
    }

    @And("A User clicks on persons button")
    public void aUserClicksOnPersonsButton() {
        Configuracion.driver.findElement(By.id("newbp-mp-zona-transaccional-personas")).click();
    }

    @And("A User enter an invalid id")
    public void aUserEntersAnInvalidId() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/h4")),
          //      "Ingresa a tu zona transaccional"));

        ArrayList<String> tabs2 = new ArrayList<String> (Configuracion.driver.getWindowHandles());
        Configuracion.driver.switchTo().window(tabs2.get(1));
        Configuracion.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).click();
        Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).sendKeys("877878877");
    }

    @And("A User clicks on continue button")
    public void aUserClicksOnContinueButton() {
        Configuracion.driver.findElement(By.id("btn_login")).click();
    }

    @Then("Applications show message Algo Salio Mal")
    public void applicationShowsMessageAlgoSalioMal() throws JsonProcessingException {

        String actualMessage =  Utilities.esperarElemento("//h4[contains(text(),'Algo')]","xpath",15).getText();

        TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(Configuracion.zcv1, 10000, 10017, 10001, "-1");

        if((actualMessage.substring(1, 5)).equals("Algo")){
            ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getPassStatus(), "Prueba OK");
        }else{
            ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getFailStatus(), "No se encontro el texto algo salio mal");

        }

        MatcherAssert.assertThat ((actualMessage.substring(1, 5)), is("Algo"));

    }

    @And("A User enter an valid id")
    public void aUserEntersAnValidId() {
        ArrayList<String> tabs2 = new ArrayList<String> (Configuracion.driver.getWindowHandles());
        Configuracion.driver.switchTo().window(tabs2.get(1));
        Configuracion.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).click();
        Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).sendKeys("3012602");
    }

    @Then("Applications show message Escribe tu contrasena")
    public void applicationShowsMessageEscribeTuContrasena() throws JsonProcessingException {
        String actualMessage = Configuracion.driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-enrollment/div/div/app-validate-universal-password/div[2]/div/h4")).getText();

        TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(Configuracion.zcv1, 10000, 10016, 10001, "-1");

        if((actualMessage.substring(0, 7)).equals("Escribe")){
            ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getPassStatus(), "Prueba OK");
        }else{
            ZephyrClient.updateTestExecutionStatus(Configuracion.zcv1, executionDto, Status.getFailStatus(), "No se encontro el texto escribe la contraseña");

        }

        MatcherAssert.assertThat ((actualMessage.substring(0, 7)), is("Escribe"));


    }

}
