package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl ="https://courses.ultimateqa.com";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        verifyText("Welcome Back!",By.xpath("//h1[contains(text(),'Welcome Back!')]"),"Welcome Back!");
    }
    @Test
    public void verifyTheErrorMessage(){

        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        sendTextToElement(By.id("user[email]"),"xyz@gmail.com");

        sendTextToElement(By.id("user[password]"),"SuperSecret1");

        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        verifyText("Invalid email or password.",By.xpath("//li[contains(text(),'Invalid email or password.')]"),"Invalid email or password.");
    }
    @After
    public void close(){
        driver.close();
    }
}
