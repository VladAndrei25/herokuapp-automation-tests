package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.xml.transform.SourceLocator;
import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class DragAndDropTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/drag_and_drop";

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
    @DisplayName("TC-01 : Is drag and drop working")
    void dragAndDrop(){
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        String beforeSourceText = source.getText();
        String beforeTargetText = target.getText();
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).perform();
        String afterSourceText = driver.findElement(By.id("column-a")).getText();
        String afterTargetText = driver.findElement(By.id("column-b")).getText();
        Assertions.assertNotEquals(beforeSourceText, afterSourceText, "Source column did not change");
        Assertions.assertNotEquals(beforeTargetText, afterTargetText, "Target column did not change");
    }
}
