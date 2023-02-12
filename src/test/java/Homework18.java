import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {

    @Test
    public void playASongTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("test123@test.com", "te$t$tudent");
        Thread.sleep(3000);
        playSong();
        isSongPlaying();
    }

    public void playSong() throws InterruptedException{

        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
        Thread.sleep(5000);

    }

    public void isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

}
