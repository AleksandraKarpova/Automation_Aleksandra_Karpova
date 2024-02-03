package HW5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class Exercise {
    @BeforeTest
    public void setUp(){
        setUpWebDriver("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
    public void test1(){
            calc("calc_roomwidth", "13");
            calc("calc_roomheight", "12");
            calc("calc_lamwidth", "600");
            calc("calc_lamheight", "900");
            calc("calc_inpack", "20");
            calc("calc_price", "550");
            calc("calc_bias", "250");
            calc("calc_walldist", "10");

            WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
            Button.click();

            WebElement result = getWebDriver().findElement(By.id("l_count"));
            Assert.assertTrue(result.isDisplayed(), "247");
        }


        @Test
        public void test2() {
            calc("calc_roomwidth", "0");
            calc("calc_roomheight", "0");
            calc("calc_lamwidth", "0");
            calc("calc_lamheight", "0");
            calc("calc_inpack", "0");
            calc("calc_price", "0");
            calc("calc_bias", "0");
            calc("calc_walldist", "0");

            WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
            Button.click();

            WebElement result = getWebDriver().findElement(By.id("l_count"));
            Assert.assertTrue(result.isDisplayed(), "200");
        }

        @Test
        public void test3() {
            calc("calc_roomwidth", "10");
            calc("calc_roomheight", "9");
            calc("calc_lamwidth", "1500");
            calc("calc_lamheight", "400");
            calc("calc_inpack", "25");
            calc("calc_price", "666");
            calc("calc_bias", "201");
            calc("calc_walldist", "13");

            WebElement Button = getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']"));
            Button.click();

            WebElement result = getWebDriver().findElement(By.id("l_count"));
            Assert.assertTrue(result.isDisplayed(), "155");
        }

        private static void calc(String locator, String value) {
            getWebDriver().findElement(By.name(locator)).click();
            getWebDriver().findElement(By.name(locator)).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"), Keys.DELETE);
            getWebDriver().findElement(By.name(locator)).sendKeys(value);
            getWebDriver().findElement(By.name(locator)).sendKeys(Keys.ENTER);
        }


        @AfterTest
        public void tearDown() {
            quit();
        }
    }
