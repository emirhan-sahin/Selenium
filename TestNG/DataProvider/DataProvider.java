package TestNG.DataProvider;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public Object[][] dataProveriderMethod() {

        Object[][] a = new Object[2][1];
        a[0][0] = "Data 1";
        a[1][0] = "Data 2";

        return a;

    }

    @Test(dataProvider = "dataProveriderMethod")
    public void testMethod1(String data) {

        System.out.println("Data : " + data);

    }


}
