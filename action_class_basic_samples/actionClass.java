import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class actionClass {
        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.etsy.com/");
            driver.manage().window().maximize();

            Actions action = new Actions(driver);

            List<WebElement> menuBars = driver.findElements(By.xpath("//ul[@role='menubar']//li"));

            // 1.Yol
            for(WebElement menubar : menuBars){
                action.moveToElement(menubar).perform();
                Thread.sleep(1000);

            }
            // 2.Yol
//            for (int i=0;i<menuBars.size();i++){
//                action.moveToElement(menuBars.get(i)).perform();
//                Thread.sleep(1000);
//            }
}
    }
