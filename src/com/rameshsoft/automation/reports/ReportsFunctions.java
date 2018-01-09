package com.rameshsoft.automation.reports;

import com.rameshsoft.automation.driverengine.DriverUtility;
import com.relevantcodes.extentreports.LogStatus;

public class ReportsFunctions 
{
     public static void LogInfo(String stepDetails )
     {
    	 DriverUtility.getExtentTest().log(LogStatus.INFO,stepDetails);
     }
     
     public static void LogInfo(String stepName,String stepDetails)
     {
    	 DriverUtility.getExtentTest().log(LogStatus.INFO, stepName,stepDetails);
     }
}
