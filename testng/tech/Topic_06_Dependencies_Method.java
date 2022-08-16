package tech;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_06_Dependencies_Method {
    @Test
    public void TC_01_Create(){
        Assert.assertTrue(false);

    }
    @Test(dependsOnMethods = "TC_01_Create")
    public void TC_02_View(){

    }
    @Test(dependsOnMethods = "TC_01_Create")
    public void TC_03_Edit(){

    }
    @Test(dependsOnMethods = {"TC_01_Create", "TC_03_Edit"})
    public void TC_04_Delete(){

    }
}
