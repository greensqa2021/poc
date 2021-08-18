package Utils;

import gsqa.gheart.sdk.java.helpers.DateTimeHelper;
import gsqa.gheart.sdk.java.models.BaseMetricInfo;
import gsqa.gheart.sdk.java.models.DevEnvironment;
import gsqa.gheart.sdk.java.models.GsqaService;
import gsqa.gheart.sdk.java.models.ProcessResult;
import gsqa.gheart.sdk.java.models.TechnologyDev;
import gsqa.gheart.sdk.java.models.TimestampRange;
import gsqa.gheart.sdk.java.services.FunctionalMetricsPublisherService;
import gsqa.gheart.sdk.java.services.IFunctionalMetricsPublisherService;

public class FunctionalMonitoring {

    public static void publish(int excelentTime, int toleratingTime, long elapsedTime, Boolean isTestSuccessful,String robotName) {
        try {
            IFunctionalMetricsPublisherService functionalPublisherService = new FunctionalMetricsPublisherService();
            BaseMetricInfo baseMetricInfo = new BaseMetricInfo(false, "123456789", "BancoPopular", "9876543210", "PocPopular",
                    "001", null, "1.0-beta", null, DateTimeHelper.getUnixTimestamp(0, TimestampRange.Milliseconds));

            functionalPublisherService.createPoint(baseMetricInfo).isTestSuccessful(isTestSuccessful)
                    .addRobotName(robotName).addRobotAuthor("ribarra")
                    .addRobotExecutionTimes(excelentTime, toleratingTime, elapsedTime).addRobotVsHumanRelationRate(1.0)
                    .addDeploymentEnvironment(DevEnvironment.DEV).addGsqaService(GsqaService.TIA)
                    .addTechnologyATM(TechnologyDev.Java).addTechnologyAPP("GreenHeart").showAllPoints();

            System.out.println(functionalPublisherService);
            ProcessResult result = functionalPublisherService.publish();
            if (result.isSuccess()) {
                System.out.println(result.getData());
            } else {
                System.out.println(result.getFailureReasonMessage());
            }
        } catch (Exception ex) {
            System.out.println("[ERROR] " + ex.getMessage());
        }

    }

}

