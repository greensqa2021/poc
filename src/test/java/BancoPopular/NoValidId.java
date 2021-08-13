package BancoPopular;

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


public class NoValidId {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/chromedriver_win32/chromedriver.exe").toString());
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }
    @After
    public void tearDown() {
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("Navigate to page BancoPopular")
    public void navigateToPageBancoPopular() {
        driver.navigate().to("https://www.bancopopular.com.co/");
    }

    @When("A User clicks on popup close")
    public void aUserClicksOnPopupClose() {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/div/section/div[2]/div/div/a")).click();
    }

    @And("A User clicks on persons button")
    public void aUserClicksOnPersonsButton() {
        driver.findElement(By.id("newbp-mp-zona-transaccional-personas")).click();
    }

    @And("A User enter an invalid id")
    public void aUserEntersAnInvalidId() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/h4")),
          //      "Ingresa a tu zona transaccional"));

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-login/div/form/div/div[2]/input")).sendKeys("877878877");
    }

    @And("A User clicks on continue button")
    public void aUserClicksOnContinueButton() {
        driver.findElement(By.id("btn_login")).click();
    }

    @Then("Applications show message Algo Salio Mal")
    public void applicationShowsMessageAlgoSalioMal() {
        String actualMessage = driver.findElement(By.xpath("/html/body/app-root/main/app-auth/div/div[2]/div/app-enrollment/div/div/app-alert/div/form/div/div/h4")).getText();

         MatcherAssert.assertThat ((actualMessage.substring(1, 5)), is("Algo"));
    }

}
