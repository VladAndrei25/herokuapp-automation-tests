package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class FormAuthentificationTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/login";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterEach
    void tearDown(){
        if ( driver != null ) { driver.quit(); }
    }

    @Test
    @DisplayName("TC01 - Authentification works")
    void testAuthentification(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        Assertions.assertTrue(
                actualResult.contains("You logged into a secure area!"),
                "Success message not found in flash banner. Actual: " + actualResult
        );
    }
}
