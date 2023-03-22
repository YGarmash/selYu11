package testFacebook;

import org.SharedDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

public class M11_Advanced_selenium_Assignment {
    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
    static WebDriver driver;


    @BeforeEach
    public void classSetup() {
        SharedDriver sharedDriver = new SharedDriver();
        driver = sharedDriver.getWebDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterEach
    public void classTearDown() {
        driver.close();
    }



    @Test
    public void emptyFields() {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[contains(text(),'Create new account')]"));
        createNewAccButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='websubmit']")));
        WebElement signUp = driver.findElement(By.cssSelector("button[name='websubmit']"));
        signUp.click();
        WebElement whatisyourname = driver.findElement(By.xpath("//*[contains(text(),'s your name?')]"));
        assertTrue(whatisyourname.isDisplayed(),"not displayed");
    }

    @Test
    public void emptyFieldAge () {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[contains(text(),'Create new account')]"));
        createNewAccButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='websubmit']")));
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstNameElement.sendKeys("first name");
        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameElement.sendKeys("last name");
        WebElement regEmailElement = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        regEmailElement.sendKeys("trytr@fdgdf.com");
        WebElement regEmailconfirmationElement = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        regEmailconfirmationElement.sendKeys("trytr@fdgdf.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='websubmit']")));
        WebElement signUp = driver.findElement(By.cssSelector("button[name='websubmit']"));
        signUp.click();
        WebElement passwordmessage = driver.findElement(By.xpath("//*[contains(text(),'Enter a combination of')]"));
        assertTrue(passwordmessage.isDisplayed(),"not displayed");
    }

    @Test
    public void registration () {
        WebElement createNewAccButton = driver.findElement(By.xpath("//*[contains(text(),'Create new account')]"));
        createNewAccButton.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='websubmit']")));
        WebElement firstNameElement = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstNameElement.sendKeys("first name");
        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameElement.sendKeys("last name");
        WebElement regEmailElement = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        regEmailElement.sendKeys("trytr@fdgdf.com");
        WebElement regEmailconfirmationElement = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
        regEmailconfirmationElement.sendKeys("trytr@fdgdf.com");
        WebElement passwordElement = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
        passwordElement.sendKeys("YuliaG1@");
        Select drpMonth = new Select(driver.findElement(By.name("birthday_month")));
        drpMonth.selectByVisibleText("Feb");
        Select drpbirthday = new Select(driver.findElement(By.name("birthday_day")));
        drpbirthday.selectByVisibleText("12");
        Select birthdayYear = new Select(driver.findElement(By.name("birthday_year")));
        birthdayYear.selectByVisibleText("1984");
        WebElement femaleButton = driver.findElement(By.xpath("//*[@name='sex' and @value=1]"));
        femaleButton.click();
        WebElement signUp = driver.findElement(By.cssSelector("button[name='websubmit']"));
        signUp.click();

    }




}
