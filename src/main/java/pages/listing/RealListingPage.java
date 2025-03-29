package pages.listing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
import pages.realtHome.RealtHomePage;

public class RealListingPage extends BasePage {
    public RealListingPage(WebDriver driver){
        super(driver);
    }
    private final By card = By.xpath("//div[@class='listing-item highlighted']");
    public RealListingPage checkCountCards(){
        waitElementIsVisible(driver.findElement(card));

        int coundCard = driver.findElements(card).size();
        Assert.assertEquals(coundCard, 20);
        return this;
    }

}
