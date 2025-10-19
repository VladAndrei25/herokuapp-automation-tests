package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AddRemoveElementsTest{
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/add_remove_elements/";

    private final By addBtn = By.xpath("//button[text()='Add Element']");
    private final By deleteBtn = By.xpath("//button[text()='Delete']");

    private int deleteCount(){
        return driver.findElements(deleteBtn).size();
    }

    private static final int N = 5;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterEach
    void tearDown(){
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("TC01 - Add one element")
    void addSingleElement(){
        driver.findElement(addBtn).click();
        Assertions.assertEquals(1, deleteCount(), "Element does not appear after adding clicking on add element");
    }

    @Test
    @DisplayName("TC02 - Add multiple elements")
    void addMultipleElements() {
        for (int i = 1; i <= N; i++) {
            driver.findElement(addBtn).click();
        }
        Assertions.assertEquals(N, deleteCount(), "Expected " + N + " Delete buttons after multiple Add clicks");
    }

    @Test
    @DisplayName("TC03 - Remove one element")
    void removeSingleElement(){
        driver.findElement(addBtn).click();
        driver.findElement(deleteBtn).click();
        Assertions.assertEquals(0, deleteCount(),  "Element is not deleted after clicking on Delete Button");
    }

    @Test
    @DisplayName("TC04 - Do not remove anything")
    void noRemovalElements(){
        for(int i = 1; i <= N; i++){
            driver.findElement(addBtn).click();
        }
        int before = deleteCount();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> deleteCount() == before);
        int after = deleteCount();
        Assertions.assertEquals(before, after, "Elements were deleted without on-click action");
    }

    @Test
    @DisplayName("TC05 - Remove All elements")
    void removeAllElements(){
        for(int i = 1; i <= N; i++){
            driver.findElement(addBtn).click();
        }
        for(int i = 1; i <= N; i++){
            driver.findElements(deleteBtn).get(0).click();
        }
        Assertions.assertEquals(0, deleteCount(), "Not all the elements were deleted");
    }
}
