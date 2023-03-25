package pages;

import helper.CommonHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormPage {

    private WebDriver driver;
    CommonHelper helper = new CommonHelper();

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;

    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> genders;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> yearsOfExperience;

    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement automationTesterCheckbox;

    @FindBy(css = "#selectContinents")
    private WebElement selectContinent;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(css = ".custom-file-input")
    private WebElement fileInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "#validator-message")
    private WebElement validatorMessage;

    public FormPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage selectRandomGender() {
        helper.getRandomElementFromList(genders).click();
        return this;
    }

    public FormPage setAge(int age) {
        ageInput.sendKeys(String.valueOf(age));
        return this;
    }

    public FormPage selectRandomExperience() {
        helper.getRandomElementFromList(yearsOfExperience).click();
        return this;
    }

    public FormPage selectAutomationTesterProfession() {
        automationTesterCheckbox.click();
        return this;
    }

    public FormPage selectContinent(String continent) {
        Select continents = new Select(selectContinent);
        continents.selectByValue(continent);
        return this;
    }

    public FormPage selectSeleniumCommands(String command) {
        Select commands = new Select(selectSeleniumCommands);
        commands.selectByValue(command);
        return this;
    }

    public FormPage uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage sendForm() {
        submitButton.click();
        return this;
    }

    public String getValidationMessage() {
        return validatorMessage.getText();
    }


}
