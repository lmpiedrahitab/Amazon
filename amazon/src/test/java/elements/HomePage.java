package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;


public class HomePage {

    WebDriver driver;
    String baseCss = "[aria-label='%s']";

    @FindBy(id = "glow-ingress-block")
    WebElement addressButton;

    @FindBy(xpath = "//span[@class= 'a-button-text a-declarative']")
    WebElement countryButton;

    @FindBy(xpath = "//button[@name = 'glowDoneButton']")
    WebElement doneButton;




    public HomePage(WebDriver driver) {
        this.driver = driver;

        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    // Click on product option from Home Page
    public void clickOption(String option) {
        String cssPath = String.format(baseCss,option);
        WebElement optElement = driver.findElement(By.cssSelector(cssPath));
        optElement.click();
    }

    // Click on go to address option
    public void clickAddress(String country) {

        addressButton.click();
        driver.switchTo().activeElement();
        countryButton.click();
        Select drpCountry = new Select(driver.findElement(By.id("GLUXCountryList")));
        drpCountry.selectByVisibleText(country);
        doneButton.click();

    }

    public void clickRandom(){
        List<WebElement> optionsCount = driver.findElements(By.xpath("//div[contains(@class, \"quadrant-container\")]"));
        Random random = new Random();
        int index = random.nextInt(optionsCount.size());
        optionsCount.get(index).click();


    }

}
