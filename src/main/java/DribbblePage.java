import org.openqa.selenium.WebDriver;

public class DribbblePage {
    WebDriver driver;

    public String url = "https://dribbble.com/";
    public String loginurl = "https://dribbble.com/session/new";
    public String LoginLink = "//a[@href='/session/new']";
    public String LoginTitle =  "//*[@id=\"main-container\"]/section[2]/main/div[1]/h2";
    public String Footer = "//*[@id=\"footer\"]/div/div[2]/div[1]";
    public String email = "ann-nuk@yandex.ru";
    public String password = "testingpassword";

    public String InputEmail = "//*[@id=\"login\"]";

    public String InputPassword = "//*[@id=\"password\"]";

    public String ButtonSignIn = "//*[@class=\"button form-sub\"]";

    public String AuthorizationTitle =  "//*[@id=\"main\"]/ol/li[1]/h2";




    public DribbblePage(WebDriver driver){
        this.driver = driver;
    }
}
