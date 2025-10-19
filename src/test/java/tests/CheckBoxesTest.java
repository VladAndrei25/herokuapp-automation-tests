package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class CheckBoxesTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/checkboxes";

    @BeforeEach
    void startUp(){
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
    @DisplayName("TC-01 - All checkboxes working")
    void allCheckboxesWorking(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement checkbox : checkboxes){
            boolean before = checkbox.isSelected();
            checkbox.click();
            boolean after = checkbox.isSelected();
            Assertions.assertNotEquals(before, after, "Checkbox state did not change after click.");
        }
    }
}
