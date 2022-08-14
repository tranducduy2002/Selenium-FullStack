package tech;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {

    @Test
    public void TC_01(){
        // Thư viện Asert: kiểm tra tính đúng đắn của dữ liệu
        // Mong đợi nó đúng/ sai/ đầu vào/ ra/ như nhau
        // Bằng null/ khác null /...
        // Kiểm tra 1 điều kiện mong đợi là luôn luôn đúng
        String addressCity = "Ho Chi Minh";
        Assert.assertTrue(addressCity.equals("Ho Chi Minh"));
        Assert.assertTrue(addressCity.contains("Minh"));

        Assert.assertFalse(addressCity.contains("Ho Chi"), "Address không chứa dữ liệu mong đợi");

        // Kiểm tra 1 điều kiện mong đợi là sai
        Assert.assertFalse(addressCity.contains("Ha Noi"));

        // Kiểm tra đầu vào và đầu ra như nhau
        Assert.assertEquals(addressCity, "Ho Chi Minh");
        // Assert.assertEquals(addressCity, "Ha Noi");

        Object fullname = "Automation";
        Assert.assertNotNull(fullname);
        Assert.assertNull(fullname);
    }
}
