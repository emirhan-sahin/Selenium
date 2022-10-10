import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Table {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://en.wikipedia.org/wiki/Dell");

        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.cssSelector("table[class='wikitable sortable jquery-tablesorter']"));

        //scroll işlemi
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", table);

        List<WebElement> satirlar = driver.findElements(By.cssSelector(".jquery-tablesorter>tbody>tr"));

        for (int i = 0; i < satirlar.size(); i++) {
            System.out.println(satirlar.get(i).getText() + "\n");
        }


        //istenilen satir ve sütun için
        ////table[@class='wikitable sortable jquery-tablesorter']//tbody//tr[1]//td[2]

        System.out.println("---------------------     ------------------------        -------------------------   -----------------------------");

        WebElement wyse = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tbody//tr[10]"));

        System.out.println(wyse.getText());

        System.out.println("---------------------     ------------------------        -------------------------   -----------------------------");


        WebElement boomi = driver.findElement(By.cssSelector("table.jquery-tablesorter>tbody>tr:nth-of-type(5)>td:nth-of-type(2)"));
        System.out.println("Boomi Company note : " + boomi.getText());

        Assert.assertEquals("Cloud integration leader", boomi.getText());

        Assert.assertTrue(boomi.getText().contains("integration"));

        System.out.println("Test başarılı ...");


    }
}
