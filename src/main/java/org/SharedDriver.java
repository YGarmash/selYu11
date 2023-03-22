package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SharedDriver {
    private  WebDriver webDriver;
    public  WebDriver getWebDriver(){
        if(webDriver==null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }



    public  void closeDriver(){
        if(webDriver != null) {
            webDriver.close();
        }

    }
}
