package tests;

import com.google.common.collect.ForwardingMapEntry;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class InputsTest {
    private WebDriver driver;
    private static String URL="https://the-internet.herokuapp.com/inputs";

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
    @DisplayName("TC01 - Is input working for random numbers")
    void isInputWorking(){
        WebElement input = driver.findElement(By.cssSelector("input[type='number']"));
        int randomNumber = ThreadLocalRandom.current().nextInt(-100000, 100000);
        System.out.println(randomNumber);
        input.sendKeys(String.valueOf(randomNumber));
        int start = Integer.parseInt(input.getAttribute("value"));
        Actions actions = new Actions(driver);
        for(int i = 0; i < 20; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
        int AfterARROW_UP = Integer.parseInt(input.getAttribute("value"));
        Assertions.assertEquals(start + 20, AfterARROW_UP, "Arrow_UP didn't increment correctly");
        for(int j = 0; j < 40; j++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        int AfterARROW_DOWN = Integer.parseInt(input.getAttribute("value"));
        Assertions.assertEquals(AfterARROW_UP - 40, AfterARROW_DOWN, "Arrow_DOWN didn't decrease correctly");
    }

    @Test
    @DisplayName("TC02 - Input should not work for letters")
    void lettersShouldNotWork(){
        WebElement input = driver.findElement(By.cssSelector("input[type='number']"));
        for(char c = 'a'; c <= 'z'; c++){
            if(c != 'e'){
                input.clear();
                input.sendKeys(String.valueOf(c));
                String actual = input.getAttribute("value");
                Assertions.assertEquals("", actual, "Input did accept letter: " + c);
            }
        }
    }

    @Test
    @DisplayName("TC03 - Input working for decimal numbers")
    void decimalInputNumbers(){
        WebElement input = driver.findElement(By.cssSelector("input[type='number']"));
        double randomNumber = ThreadLocalRandom.current().nextDouble(-99999.9,99999.9);
        System.out.println(randomNumber);
        input.sendKeys(String.valueOf(randomNumber));
        double start = Double.parseDouble(input.getAttribute("value"));
        Actions actions = new Actions(driver);
        for ( int i = 0; i < 20; i++ ){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
        double afterARROW_UP = Double.parseDouble(input.getAttribute("value"));
        Assertions.assertTrue(afterARROW_UP > start, "Value did not increase after ARROW_UP");
        for ( int j = 0; j < 40; j++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        double afterARROW_DOWN = Double.parseDouble(input.getAttribute("value"));
        Assertions.assertTrue(afterARROW_DOWN < afterARROW_UP, "Value did not decrease after ARROW_DOWN");
    }

    @Test
    @DisplayName("TC04 - Input should not work for special characters")
    void specialCharsInput(){
        WebElement input = driver.findElement(By.cssSelector("input[type='number']"));
        Map<String, String> specialChars = new HashMap<>();
        specialChars.put("!", "");
        specialChars.put("@", "");
        specialChars.put("#", "");
        specialChars.put("$", "");
        specialChars.put("%", "");
        specialChars.put("^", "");
        specialChars.put("&", "");
        specialChars.put("*", "");
        specialChars.put("(", "");
        specialChars.put(")", "");
        specialChars.put("+", "");
        specialChars.put("=", "");
        specialChars.put("_", "");
        specialChars.put("[", "");
        specialChars.put("]", "");
        specialChars.put("{", "");
        specialChars.put("}", "");
        specialChars.put(":", "");
        specialChars.put(";", "");
        specialChars.put("'", "");
        specialChars.put("\"", "");
        specialChars.put("\\", "");
        specialChars.put("|", "");
        specialChars.put("/", "");
        specialChars.put("?", "");
        specialChars.put("~", "");
        specialChars.put("`", "");
        specialChars.put(",", "");
        for(Map.Entry<String, String> entry : specialChars.entrySet()){
            String key = entry.getKey();
            String expected = entry.getValue();
            input.clear();
            input.sendKeys(key);
            String actual = input.getAttribute("value");
            Assertions.assertEquals(expected, actual, "Input accepted special char: " + key);
        }
    }
 }

