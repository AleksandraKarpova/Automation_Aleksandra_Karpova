package HW6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class Saucedemo {

    @BeforeTest
    public void setUp(){
        setUpWebDriver("https://www.saucedemo.com/");
    }

    @Test (priority = 1)
    public void loginTest() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.name("login-button")).click();
    }

    @Test (priority = 2)
    public void addToCardTest() {
        getWebDriver().findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        getWebDriver().findElement(By.cssSelector("[name$='shirt']")).click();
        getWebDriver().findElement(By.cssSelector("[name*='fleece']")).click();
        getWebDriver().findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name']")).getText(),"Sauce Labs Backpack", "Error");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_price']")).getText(),"$29.99", "Wrong price");
    }

    @Test (priority = 3)
    public void removeToCardTest() {
        getWebDriver().findElement(By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']")).click();
        getWebDriver().findElement(By.xpath("//button[@data-test='remove-sauce-labs-bolt-t-shirt']")).click();
        getWebDriver().findElement(By.xpath("//a[contains(@class,'link')]")).click();
        Assert.assertNotEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name']")).getText(),"Sauce Labs Bolt T-Shirt", "Error");
    }

    @AfterTest
    public void tearDown() {
        quit();
    }
}