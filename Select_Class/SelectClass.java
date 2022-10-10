import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectClass {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        WebElement cookies = driver.findElement(By.cssSelector("span.cookie-choices-buttons>:nth-child(2)"));
        cookies.click();

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Emirhan");


        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("ŞAHİN");

        WebElement gender = driver.findElement(By.xpath("//input[@value='Male']"));
        gender.click();

        List<WebElement> list = driver.findElements(By.cssSelector("div[dir=ltr]>:nth-child(14)>input"));

        for (int i=0; i<list.size();i++){
            list.get(i).click();
            Thread.sleep(500);
        }

        WebElement date= driver.findElement(By.cssSelector("#datepicker"));
        date.sendKeys("01.10.2021");

        WebElement profession = driver.findElement(By.xpath("//input[@value='Automation Tester']"));
        profession.click();

        List<WebElement> automation = driver.findElements(By.cssSelector("input[name=tool]"));

       // List<WebElement> automation1 = driver.findElements(By.xpath("(//div[@class='control-group'])[7]//input"));

        for (int i=0; i<automation.size();i++){
            automation.get(i).click();
            Thread.sleep(500);
        }


        //Select Class

        WebElement element = driver.findElement(By.cssSelector("#continents"));

        Select slc = new Select(element);
        slc.selectByVisibleText("Australia");


        element = driver.findElement(By.cssSelector("#selenium_commands"));
        slc = new Select(element);
        slc.selectByIndex(0);
        slc.selectByIndex(1);




    }

}
