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

public class Exercize2 {
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
    public void test2() {
        driver.get("https://www.google.by/");
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("-DskipTests=true");
        driver.findElement(By.cssSelector("center:nth-child(1) > .gNO89b")).click();
        driver.findElement(By.cssSelector("p:nth-child(1)")).click();
        assertThat(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(), is("По запросу -DskipTests=true ничего не найдено. "));
        driver.close();
    }

    private void assertThat(String text, ElementMatcher.Junction<Object> objectJunction) {

    }
}
