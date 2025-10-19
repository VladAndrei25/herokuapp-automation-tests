package tests;

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class DissapearingElementsTest {
    private WebDriver driver;
    private static String URL = "https://the-internet.herokuapp.com/disappearing_elements";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterEach
    void tearDown(){
        if( driver != null) { driver.quit(); }
    }

    @Test
    @DisplayName("TC01 - After some refreshes 1 element disspear / reappear")
    void refreshDissapearAppear(){
        int before = driver.findElements(By.cssSelector(" #content ul li a")).size();
        boolean changed = false;
        for ( int i = 1; i <= 10; i++){
        driver.navigate().refresh();
        int after = driver.findElements(By.cssSelector(" #content ul li a")).size();
        if( before != after ){
            changed = true;
            break;
            }
        }
        Assertions.assertTrue(changed, "Elements did not change in the menu");
     }
}
