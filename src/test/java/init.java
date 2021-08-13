import com.fasterxml.jackson.core.JsonProcessingException;
import com.greensqa.zapiconsumer.ZephyrClient;
import com.greensqa.zapiutil.ZapiClientV1;
import com.greensqa.zapiutil.dto.Status;
import com.greensqa.zapiutil.dto.TestCaseExecution;

public class init {


    private static final String ACCOUNT_ID = "raparrap@gmail.com:61158ac975ad960069aeec33";
    private static final String ACCESS_KEY = "Y2IzNDBiMDYtZjUzOS0zZDc1LWE4ZjgtODY0YTA4NDk5MDhhIDU1NzA1OCUzQTg5ZjdiNjNlLTU3ODAtNDM2Ny1hMDdiLTNmOTY3MDI2OTgxMyBVU0VSX0RFRkFVTFRfTkFNRQ";
    private static final String SECRET_KEY = "dXhn_yIclf63W1zn2RnZ6claVmf1U-spujvKuY8BDXg";


    public static void main(String[] args) throws JsonProcessingException {
        // TODO Auto-generated method stub

        ZapiClientV1 zcv1 = new ZapiClientV1(ACCOUNT_ID, ACCESS_KEY, SECRET_KEY);

        //En las URL del proeycto se puedenobtener los datos de proyecto, issue, version, cycle
        //https://eid3r.atlassian.net/plugins/servlet/ac/com.thed.zephyr.je/general-search-test-executions?project.id=10000&issue.id=10014&execution.id=2db6ae62-98c4-4385-ab8b-1cd5eca33f17&view=detail&zql=issue%20%3D%20BP-15
        TestCaseExecution executionDto = ZephyrClient.createTestCaseExecution(zcv1, 10000, 10007, 10001, "-1");

        SimulateBotExec();

        ZephyrClient.updateTestExecutionStatus(zcv1, executionDto, Status.getPassStatus(), "Prueba OK");
    }


    private static void SimulateBotExec()
    {
        System.out.println("Simulating robot execution");
        delayConsole();
        System.out.println("Simulation robot execution finished");
        System.out.println("");
    }


    private static void delayConsole() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
