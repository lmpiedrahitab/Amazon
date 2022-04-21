package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeadsetPage {

    WebDriver driver;

    @FindBy(className = "sg-col-inner")
    WebElement headsetMenu;

    @FindBy(xpath = "(//div[@class='aok-relative'])[1]")
    WebElement headsetOption;

    public HeadsetPage(WebDriver driver) {

        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Get Headset in the menu
    public WebElement getHeadsetMenu() {
        return headsetMenu;
    }

    // Click on first option from Headset results
    public void clickFirstOption() {
        headsetOption.click();
    }
}
