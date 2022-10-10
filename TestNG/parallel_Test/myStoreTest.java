package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class myStoreTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    @BeforeClass
    @Parameters({"browser"})
    public void Setup(String browser) {
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","D:/Selenium/geckodriver.exe");
            driver= new FirefoxDriver();
        } else {
            System.out.println("Geçerli bir tarayıcı adı girin.");
        }
        // wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void Test1() throws InterruptedException {
        Actions action = new Actions(driver);
        List<WebElement> menuBar = driver.findElements(By.cssSelector(".sf-menu>li"));
        action.moveToElement(menuBar.get(0)).perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//a[@title='Casual Dresses'])[1]")).click();
        Thread.sleep(1000);

        WebElement list = driver.findElement(By.xpath("//i[@class=\"icon-th-list\"]"));
        list.click();
        Thread.sleep(1000);

        WebElement button = driver.findElement(By.cssSelector(".button.lnk_view.btn.btn-default"));
        button.click();
        Thread.sleep(1000);

        List<WebElement> images= driver.findElements(By.cssSelector("#thumbs_list_frame>li"));
        for (int i = 0; i < images.size(); i++) {
            action.moveToElement(images.get(i)).perform();
            Thread.sleep(1000);
        }


        driver.findElement(By.cssSelector("#wishlist_button")).click();
        Thread.sleep(2000);

        WebElement loginMessage = driver.findElement(By.xpath("//p[text()='You must be logged in to manage your wishlist.']"));
       // wait.until(ExpectedConditions.visibilityOf(loginMessage));
        Thread.sleep(2000);
        Assert.assertEquals(loginMessage.getText(), "You must be logged in to manage your wishlist.");
        System.out.println(loginMessage.getText());
    }

    @AfterClass
    public void beforeClass() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

}

