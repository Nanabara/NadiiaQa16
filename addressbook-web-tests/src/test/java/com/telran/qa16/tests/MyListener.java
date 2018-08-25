package com.telran.qa16.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

   @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("element" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(by + "found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
       File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File screen  =
                new File("screen-"+System.currentTimeMillis()+ ".png");

        try {
            com.google.common.io.Files.copy(tmp,screen);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.error("Error log" + throwable + screen);
    }
}
