package pageobjects.genericactions;

import org.openqa.selenium.By;
import pageobjects.LogInPage;

/** Utility class that contains Button action implementation */
public class Button {

    private final By locator;
    private final LogInPage page;

    public Button(By locator, LogInPage page) {
        this.locator = locator;
        this.page = page;
    }

    public void click(){
        page.getDriver().findElement(locator).click();
    }
}
