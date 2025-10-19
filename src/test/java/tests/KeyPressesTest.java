package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import javax.swing.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class KeyPressesTest {
    private WebDriver driver;
    private static String URL = "https://the-internet.herokuapp.com/key_presses";

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
    @DisplayName("TC01 - Key presses working")
    void isKeyPressingWorking(){
        Actions actions = new Actions(driver);
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("a", "A");
        keyMap.put("z", "Z");
        keyMap.put("0", "0");
        keyMap.put("9", "9");
        keyMap.put(",", "COMMA");
        keyMap.put("'", "QUOTE");
        keyMap.put(" ", "SPACE");
        keyMap.put("/", "SLASH");
        keyMap.put(Keys.ENTER.toString(), "ENTER");
        keyMap.put(Keys.SHIFT.toString(), "SHIFT");
        keyMap.put(Keys.ESCAPE.toString(), "ESCAPE");
        keyMap.put(Keys.TAB.toString(), "TAB");
        keyMap.put(Keys.ARROW_UP.toString(), "UP");
        keyMap.put(Keys.F2.toString(), "F2");
        for ( String key : keyMap.keySet()){
            actions.sendKeys(key).perform();
            actions.click().perform();
            String result = driver.findElement(By.id("result")).getText().trim();
            String expected = "You entered: " + keyMap.get(key);
            Assertions.assertEquals(expected, result);
        }
    }
}
