package pageobjects.genericactions;

import org.openqa.selenium.By;
import pageobjects.LogInPage;
import pageobjects.PageBase;

/** Utility class that contains Field action implementation */
public class Field {

    private final By locator;
    private final PageBase page;

    public Field(By locator, LogInPage page) {
        this.locator = locator;
        this.page = page;
    }

    public void setText(String text){
        page.getDriver().findElement(locator).sendKeys(text);
    }
}
