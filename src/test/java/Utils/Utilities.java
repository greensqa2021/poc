package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Utilities {

    public static WebElement esperarElemento(String locator, String type, int tiempo) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(Configuracion.driver)
                .withTimeout(tiempo, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement elementoPagina = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                switch (type) {
                    case "css":
                        return driver.findElement(By.cssSelector(locator));
                    case "xpath":
                        return driver.findElement(By.xpath(locator));
                    case "id":
                        return driver.findElement(By.id(locator));
                    case "class":
                        return driver.findElement(By.className(locator));
                    case "name":
                        return driver.findElement(By.className(locator));
                    default:
                        break;

                }

                return null;
            }
        });
        return elementoPagina;
    }
}
