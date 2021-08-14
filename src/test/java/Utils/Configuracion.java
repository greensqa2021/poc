package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greensqa.zapiutil.ZapiClientV1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * <pre>
 * Fecha      Autor
 * 17-11-2018 Dilan Steven Mejia
 * </pre>
 *
 * Aqui se inicia la configuración del driver y el js como un singleton
 * para que se pueda utilizar solo en la capa de view y no se instancie mas
 * de una vez.
 *
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category Utils
 * **/


public class Configuracion {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static ZapiClientV1 zcv1;


    private static final String ACCOUNT_ID = "raparrap@gmail.com:61158ac975ad960069aeec33";
    private static final String ACCESS_KEY = "Y2IzNDBiMDYtZjUzOS0zZDc1LWE4ZjgtODY0YTA4NDk5MDhhIDU1NzA1OCUzQTg5ZjdiNjNlLTU3ODAtNDM2Ny1hMDdiLTNmOTY3MDI2OTgxMyBVU0VSX0RFRkFVTFRfTkFNRQ";
    private static final String SECRET_KEY = "dXhn_yIclf63W1zn2RnZ6claVmf1U-spujvKuY8BDXg";


    public static void iniciarZapiClientV1() {

        zcv1 = new ZapiClientV1(ACCOUNT_ID, ACCESS_KEY, SECRET_KEY);
    }


    public static void iniciarConfiguracion(){

        switch (PATH.NAVEGADOR) {
            case CHROME:
                // crea una nueva instancia
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.get(PATH.URL);
                js = (JavascriptExecutor)driver;

                break;
            case FIREFOX:
                // crea una nueva instancia
                driver.get(PATH.URL);
                driver.manage().window().maximize();
                break;
            case IE:
                // crea una nueva instancia
                driver.get(PATH.URL);
                break;
            default:
                // crea una nueva instancia
                driver.get(PATH.URL);
                break;
        }

    }



}