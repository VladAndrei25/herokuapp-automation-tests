package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class RightClickContextTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/context_menu";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterEach
    void tearDown(){
        if( driver != null) { driver.quit(); }
    }

    @Test
    @DisplayName("TC01 - Right click working")
    void rightClickWorking(){
        WebElement hotspot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(hotspot).perform();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("You selected a context menu", alert.getText());
        alert.accept();
    }
}


