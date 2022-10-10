package TestNG.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookTask {


    @DataProvider
    public Object[][] facebookData(){

        Object[][] data = new Object[3][2];

        data[0][0] = "emir@gmail.com";
        data[0][1] = "emir123";

        data[1][0] = "bedir@gmail.com";
        data[1][1] = "bedir123";

        data[2][0] = "sedir@gmail.com";
        data[2][1] = "sedir123";

        return data;


    }


    @Test(dataProvider = "facebookData")
    public void faceData(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);

        Thread.sleep(2000);

        driver.quit();

    }




}
