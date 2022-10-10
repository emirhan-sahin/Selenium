import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class actionClass2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();

        // Başkentler

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement stockholm = driver.findElement(By.id("box2"));

        //Ülkeler

        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement unitedStates = driver.findElement(By.id("box103"));


        Actions action = new Actions(driver);
        action.dragAndDrop(oslo, norway).build().perform();
        action.dragAndDrop(madrid, spain).build().perform();
        action.dragAndDrop(copenhagen, denmark).build().perform();
        action.dragAndDrop(rome, italy).build().perform();
        action.dragAndDrop(seoul, southKorea).build().perform();
        action.dragAndDrop(stockholm, sweden).build().perform();
        action.dragAndDrop(washington, unitedStates).build().perform();


    }
}
