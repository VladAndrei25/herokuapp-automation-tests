package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class BrokenImagesTest {
    private WebDriver driver;
    private final String URL = "https://the-internet.herokuapp.com/broken_images";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("TC01 - All images are valid")
    void allImagesValid(){
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for(WebElement image : images){
            Long naturalWidth = (Long) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].naturalWidth;", image);
                Assertions.assertTrue(naturalWidth > 0, image.getAttribute("src"));
            }
        }

    @Test
    @DisplayName("TC02 - Broken images report")
    void reportBrokenImages(){
        List<WebElement> images = driver.findElements(By.tagName("img")); // plural
        StringBuilder broken = new StringBuilder();
        for(WebElement image : images){  // fiecare imagine din listă
            Long naturalWidth = (Long) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth;", image);
            if(naturalWidth == 0){
                broken.append(image.getAttribute("src")).append("\n");
            }
        }
        Assertions.assertTrue(broken.length() == 0, "Broken images found:\n" + broken);
    }

    @Test
    @DisplayName("TC-03 - How many images are valid and how many are broken")
    void isImageValid(){
        int countValid = 0, countBroken = 0;
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for(WebElement image : images){
            Long naturalWidth = (Long) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth;", image);
            if(naturalWidth > 0){
                countValid++;
            } else if(naturalWidth == 0 ){
                countBroken++;
            }
        }
        System.out.println("Valid images: " + countValid);
        System.out.println("Broken images: " + countBroken);
        Assertions.assertTrue(countBroken == 0, "There are broken images");
    }
}

