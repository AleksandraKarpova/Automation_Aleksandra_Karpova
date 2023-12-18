package HW4;

import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
public class Exercize1 {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void untitled() {
        driver.get("https://www.google.by/");
        driver.findElement(By.cssSelector(".SDkEP")).click();
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Привет, мир");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.cssSelector(".IsZvec em")).click();
        assertThat(driver.findElement(By.cssSelector(".IsZvec em")).getText(), is("Мир"));
    }

    private void assertThat(String text, ElementMatcher.Junction<Object> мир) {

    }

}

