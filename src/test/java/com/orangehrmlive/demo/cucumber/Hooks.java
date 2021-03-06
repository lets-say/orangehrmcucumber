package com.orangehrmlive.demo.cucumber;



import com.cucumber.listener.Reporter;
import com.orangehrmlive.demo.propertyreader.PropertyReader;
import com.orangehrmlive.demo.utility.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends Utility {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
        Reporter.assignAuthor("kavan");
    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            String screenShotPath = Utility.getScreenshot(driver, scenario.getName().replace("","_"));
            Reporter.addScreenCaptureFromPath(screenShotPath);
        }
        closeBrowser();
    }

}
