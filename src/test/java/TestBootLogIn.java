
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LogInPage;
import pageobjects.UserPage;

import java.util.Arrays;

@RunWith(Parameterized.class)
public final class TestBootLogIn {

    private static final String EXPECTED_LOGIN_STRING = "Welcome back! Please sign in";
    private static final String EXPECTED_USER_STRING = "My snippets";
    private static final String EXPECTED_USER_URL = "https://bootsnipp.com/user";

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Parameter(0)
    public String email;

    @Parameter(1)
    public String password;

  /**
   * To run the test with multiple users just add more email+password items to the list.
   **/
  @Parameters
  public static Iterable<Object[]> data() {
      return Arrays.asList(new Object[][] { { "spikezhe@gmail.com", "555666777" } });
  }

  /**
   * Testing Login page.
   *
   *    - Navigates to the logIn page.
   *    - Sets credentials.
   *    - Updates Checkbox.
   *    - Asserts successful Login.
   **/
  @Test
  public void testLogIn() {
      LogInPage logInPage = new LogInPage(driver).navigate();
      // Asserts that the text in the login page is as expected.
      // (I usually don't like to add more then one assertion in a test, but it was required.)
      assertTrue("The test failed to navigate to the Login page. ",
              logInPage.isTextPresent(EXPECTED_LOGIN_STRING));

      //Non navigating actions return the same page object so that they can be easily stringed together.
      logInPage.setEmail(email)
                .setPassword(password)
                .updateRememberCheckBox(true);
      // Login page submit method returns the user Page object.
      UserPage userPage = logInPage.submit();
      // Asserts that the path navigated to is the expected one.
      assertEquals(userPage.getDriver().getCurrentUrl(), EXPECTED_USER_URL);
      // Asserts that the text in the login page is as expected.
      assertTrue("The test failed navigate to the User page. ", userPage.isTextPresent(EXPECTED_USER_STRING));
    }

    @After
    public void cleanup(){
        driver.quit();
    }
}
