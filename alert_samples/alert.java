
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class alert {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.demo.guru99.com/test/delete_customer.php");
        driver.manage().window().maximize();


        // WebElement customerID = driver.findElement(By.name("cusid"));
        WebElement customerID = driver.findElement(By.xpath("//input[@name='cusid']"));
        customerID.sendKeys("emir123");

        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
        submitButton.click();

        Thread.sleep(1000);
        // alert reddetme
        //driver.switchTo().alert().dismiss();

        // beklenen mesaj ile alert den gelen mesaj aynı mı ?
        // 2 alert geliyor. İlkinde aynı ise kabul ediyor. 2. alert de beklediğimiz gibi ise kabul edip mesajı çıktı olarak veriyor. Bu şekilde işlemin gerçelşetiğini görmüş oluyoruz.
        Assert.assertEquals("Do you really want to delete this Customer?", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        Assert.assertEquals("Customer Successfully Delete!", driver.switchTo().alert().getText());
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
}

