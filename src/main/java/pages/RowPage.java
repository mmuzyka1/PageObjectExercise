package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowPage {

    public RowPage(WebElement element) {
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(xpath = "./td[1]")
    private WebElement peak;

    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;

    @FindBy(xpath = "./td[3]")
    private WebElement state;

    @FindBy(xpath = "./td[4]")
    private WebElement height;

    public void printInfo() {
        System.out.println(rank.getText() + " " + peak.getText() + " " + mountainRange.getText());
    }

    public int getPeakHeight() {
        return Integer.parseInt(height.getText());
    }

    public boolean validateHeight(int height) {
        return getPeakHeight() > height;
    }

    public boolean validateCountry(String country) {
        return state.getText().contains(country);
    }
}
