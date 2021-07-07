package pageobjects.genericactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.LogInPage;

/** Utility class that contains CheckBox action implementation */
public class CheckBox {

    private final By locator;
    private final LogInPage page;

    public CheckBox(By locator, LogInPage page) {
        this.locator = locator;
        this.page = page;
    }

  /** @param value Boolean value that controls what is the desired state of the checkbox
   *
   *               true = checked
   *               false = unchecked
   * */
  public void updateTo(boolean value) {
        WebElement box = page.getDriver().findElement(locator);
        if (isChecked(box) && !value || !isChecked(box) && value){
            box.click();
        }
    }

    private boolean isChecked(WebElement checkbox){
        return checkbox.isSelected();
    }
}
