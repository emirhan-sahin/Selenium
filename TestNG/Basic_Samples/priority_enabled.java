package TestNG;

import org.testng.annotations.Test;


 //priority sayesinde testlerimi istedigim sıraya koyabilirim.

 //Enabled : Hangi test methodunun yanına eklersem, o method görmezden gelinir. Konsolda çıktı olarak bize gösterilmez.

public class priority_enabled {


    @Test(enabled = false)
    public void a(){
        System.out.println("a");

    }
    @Test(priority = 2)
    public void b(){
        System.out.println("b");

    }
    @Test(priority = 3)
    public void c(){
        System.out.println("c");

    }
}
