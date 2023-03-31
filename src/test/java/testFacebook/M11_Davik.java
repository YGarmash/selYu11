package testFacebook;

import org.SharedDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class M11_Davik {
        private static final String HOME_PAGE_URL = "https://daviktapes.com/";
        static WebDriver driver;


        @BeforeEach
        public void classSetup() {
            SharedDriver sharedDriver = new SharedDriver();
            driver = sharedDriver.getWebDriver();
            driver.get(HOME_PAGE_URL);
            driver.manage().window().fullscreen();
        }

        @AfterEach
        public void classTearDown() {
            driver.close();
        }



        @Test
        public void actionsClass() {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            Actions builder = new Actions(driver);


            //tabs elements
            WebElement link_Company = driver.findElement(By.xpath("//*[contains(text(),'Company')]"));
            WebElement link_Product = driver.findElement(By.xpath("//*[contains(text(),'Product')]"));
            WebElement link_Industries = driver.findElement(By.xpath("//*[contains(text(),'Industries')]"));
            WebElement link_Knowledge_Center = driver.findElement(By.xpath("//*[contains(text(),'Knowledge Center')]"));


            //hover first tab
            builder.moveToElement(link_Company).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Quality')]")));
            builder.moveToElement(link_Product).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Pest Control')]")));
            builder.moveToElement(link_Industries).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Retail')]")));
            builder.moveToElement(link_Knowledge_Center).build().perform();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Events')]")));


        }
}
