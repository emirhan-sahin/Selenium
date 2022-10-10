import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStroreTest_addToCart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        driver.manage().window().maximize();

        WebElement textArea = driver.findElement(By.cssSelector("input[name='search']"));
        textArea.sendKeys("iphone");
        textArea.sendKeys(Keys.ENTER);

        WebElement list = driver.findElement(By.cssSelector("#list-view"));
        list.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector(" button[onclick*='cart']"));
        addToCartButton.click();

        Thread.sleep(1000);

        WebElement alert = driver.findElement(By.cssSelector(".alert.alert-success "));
        ;
        //1.yol
        String myAlert = "Success: You have added iPhone to your shopping cart!\n" +
                "×";
        Assert.assertEquals(myAlert, alert.getText());
        System.out.println("Test-1 başarılı...");


        //2.yol
        Assert.assertTrue(alert.getText().contains("Success"));
        System.out.println("Test-2 başarılı...");


        WebElement cartButton = driver.findElement(By.cssSelector("#cart-total"));
        cartButton.click();

        WebElement totalPrice = driver.findElement(By.cssSelector("table.table.table-bordered>tbody>tr:nth-of-type(4)>td:nth-of-type(2)"));
        System.out.println(totalPrice.getText());

        String myTotal = "$123.20";

        Assert.assertEquals(myTotal, totalPrice.getText());

        System.out.println("Fiyat karta yansımıştır...");

        Thread.sleep(3000);

        WebElement removeButton = driver.findElement(By.cssSelector(".btn.btn-danger"));
        removeButton.click();

        Thread.sleep(1000);


        WebElement cartButton2 = driver.findElement(By.cssSelector("span[id=cart-total]"));
        cartButton2.click();

        WebElement removeMessage = driver.findElement(By.cssSelector("p[class=text-center]"));
        System.out.println(removeMessage.getText());
        //1.yl
        Assert.assertTrue(removeMessage.getText().contains("empty"));
        System.out.println("Kartınız boş-1 ...");


        //2.yol
        String expectMessage = "Your shopping cart is empty!";
        Assert.assertEquals(expectMessage, removeMessage.getText());
        System.out.println("Kartınız boş-2 ...");


    }
}

