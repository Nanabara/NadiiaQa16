package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);

    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void login(String userName, String password) {
        type(By.name("user"),userName);
        type(By.name("pass"),password);

        wd.findElement(By.xpath("//*[@value ='Login']")).click();
    }


}
