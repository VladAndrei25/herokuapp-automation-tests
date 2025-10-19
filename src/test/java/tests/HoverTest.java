package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class HoverTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/hovers";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterEach
    void tearDown(){
        if ( driver != null) { driver.quit(); }
    }

    @Test
    @DisplayName("TC-01 - Hovers are working")
    void hoversWorking(){
        List<WebElement> figures = driver.findElements(By.className("figure"));
        Actions actions = new Actions(driver);

        int index = 1;
        for (WebElement figure : figures) {
            actions.moveToElement(figure).perform();

            WebElement caption = figure.findElement(By.className("figcaption"));
            Assertions.assertTrue(caption.isDisplayed(),
                    "Figcaption not displayed for user " + index);

            String text = caption.getText();
            Assertions.assertTrue(text.contains("name: user" + index),
                    "Expected name for user " + index + " but got: " + text);
            Assertions.assertTrue(text.contains("View profile"),
                    "Expected 'View profile' for user " + index);

            index++;
        }
    }
}
