package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.genericactions.Button;
import pageobjects.genericactions.CheckBox;
import pageobjects.genericactions.Field;


public final class LogInPage extends PageBase {

    private final Field email = new Field(By.name("email"), this);
    private final Field password = new Field(By.name("password"), this);
    private final Button login = new Button(By.xpath("//input[@type=\"submit\"]"),this);
    private final CheckBox rememberMe = new CheckBox(By.name("remember"), this);

    private static final String LOGIN_URL = "https://bootsnipp.com/login";


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LogInPage navigate() {
        this.getDriver().get(LOGIN_URL);
        return this;
    }

    public LogInPage setEmail(String emailText){
        email.setText(emailText);
        return this;
    }
    public LogInPage setPassword(String passwordText){
        password.setText(passwordText);
        return this;
    }

    public UserPage submit() {
        login.click();
        return new UserPage(this.getDriver());
    }

    public LogInPage updateRememberCheckBox(boolean value){
        rememberMe.updateTo(value);
        return this;
    }
}
