package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Base Page object that should be inherited by specific ones */
public class PageBase {
    private final WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

  /** Page Object should implement a navigation method That contain the direct path to the page. */
  public PageBase navigate() throws Exception {
        throw new Exception("You should use a specific Page");
    }

  /**
   * A useful utility method that enables checking if a text value exists on the page.
   *
   * @param text - A string that will be searched on the page.
   * @return A boolean that indicates if the text is present on the page.
   */
  public boolean isTextPresent(String text) {
        String locator = String.format("//*[text()='%s' or contains(text(), '%s')]", text,text);
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }
}