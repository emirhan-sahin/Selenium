import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.tutorialsninja.com/demo/index.php?route=common%2Fhome");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='Register']")).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys("Emirhan");
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys("ŞAHİN");
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys("deneme1234@gmail.com");
        driver.findElement(By.cssSelector("input[name=telephone]")).sendKeys("5369856236");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("12345");
        driver.findElement(By.cssSelector("input[name=confirm]")).sendKeys("12345");

        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();

        driver.findElement(By.cssSelector("input[type=submit]")).click();
        Thread.sleep(1000);

        Assert.assertEquals("Your Account Has Been Created!", driver.getTitle());
        System.out.println("Hesabınız başarılı bir şekilde oluşturuldu. Tebrikler");


    }
}
