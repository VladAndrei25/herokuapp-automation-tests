package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class DropDownTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/dropdown";

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
    @DisplayName("TC-01 - Is dropdown working")
    void dropdown(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        for(int i = 0; i < options.size(); i++) {
            String text = options.get(i).getText().trim();
            if (text.isEmpty() || text.equalsIgnoreCase("Please select an option")) {
                continue;
            }
            select.selectByIndex(i);
            String selectedText = select.getFirstSelectedOption().getText().trim();
            Assertions.assertEquals(text, selectedText, "Wrong option selected at index " + i);
        }

        /*
        // unefficient way, work only for 2, if there are 100 it will take a lot of coding
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Assertions.assertEquals("Option 1", select.getFirstSelectedOption().getText(), "Wrong option selected");
        select.selectByIndex(2);
        Assertions.assertEquals("Option 2", select.getFirstSelectedOption().getText(), "Wrong option selected");*/
    }
}
