import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DribbbleTest {

    WebDriver driver;
    DribbblePage page;


    @Test
    public void testOpenDribbbleWebSite() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new DribbblePage(driver);
        driver.get(page.url);

        // TODO GIVEN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String expected = "© 2022 Dribbble. All rights reserved.";

        // TODO WHEN
        driver.get(page.url);
        WebElement element = driver.findElement(By.xpath(page.Footer));
        Util.waiter();
        String actual = element.getText();

        // TODO THEN
        Assert.assertEquals(expected, actual);
        driver.quit();
    }


    @Test
    public void testOpenLoginPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new DribbblePage(driver);
        driver.get(page.url);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = page.url;
        String xpathLoginLink = page.LoginLink;
        String xpathLoginTitle =  page.LoginTitle;
        String expected = "Sign in to Dribbble";
        driver.get(url);

        // TODO WHEN

        WebElement elementLoginLink = driver.findElement(By.xpath(xpathLoginLink));
        elementLoginLink.click();
        Util.waiter();
        WebElement elementLoginTitle = driver.findElement(By.xpath(xpathLoginTitle));
        String actual = elementLoginTitle.getText();

        // выполнить проверку текстов
        Assert.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void testLogIn(){

        String expected2 = "You aren’t following anyone yet";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new DribbblePage(driver);
        driver.get(page.url);

        String loginurl = page.loginurl;
        driver.get(loginurl);

        By InputEmail = By.xpath(page.InputEmail);
        WebElement elementInputEmail = driver.findElement(InputEmail);
        elementInputEmail.sendKeys(page.email);


        By InputPassword = By.xpath(page.InputPassword);
        WebElement elementInputPassword = driver.findElement(InputPassword);
        elementInputPassword.sendKeys(page.password);

        By ButtonSignIn = By.xpath(page.ButtonSignIn);
        WebElement elementButtonSignIn = driver.findElement(ButtonSignIn);
        elementButtonSignIn.click();

        Util.waiter();

        WebElement elementAuthorizationTitle = driver.findElement(By.xpath(page.AuthorizationTitle));
        String actual = elementAuthorizationTitle.getText();

        Assert.assertEquals(expected2, actual);
        driver.quit();
    }

}
