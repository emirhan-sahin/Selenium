import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class AlertTypes {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();


        //todo                          Basit Uyarı
        //WebElement button1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        WebElement button1 = driver.findElement(By.cssSelector(".btn.btn-danger"));
        button1.click();
        Thread.sleep(2000);
        String message1 = driver.switchTo().alert().getText();
        System.out.println(message1);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        //todo                  Teyit Uyarıları
        WebElement button2 = driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        button2.click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(1500);
        driver.switchTo().alert().dismiss();


        //todo              input bekleyen uyarılar
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.cssSelector(".btn.btn-info")).click();
        Thread.sleep(1500);

        driver.switchTo().alert().sendKeys("Emirhan");
        Thread.sleep(1500);

        driver.switchTo().alert().accept();

        String message = driver.findElement(By.cssSelector("#demo1")).getText();

        System.out.println("Mesajım : " + message);


}
}
