package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Basit_Test {


    @BeforeClass
    public void beforeClass(){


        System.out.println("SİSTEM BAŞLATILIYOR .....");
    }
//@Test(enabled = false)
    @Test
    public void test1(){


        Random random = new Random();
        int a= random.nextInt(10);
        int b= random.nextInt(10);

        int c = a+b;


        System.out.println("c : "+c);
        Assert.assertTrue(c<12);
       // Assert.fail("Assert Fail");  // Hata fırlatmaya yarar 

    }
    @Test
    public void test2(){
        String a= "Trabzonspor";
        String b= "Trabzonspor";

       Assert.assertEquals(b,a);
       // Assert.fail("Assert Fail");  // Hata fırlatmaya yarar
    }
    @AfterClass
    public void afterClass(){

        System.out.println("SİSTEM KAPATILIYOR ....");
    }
}
