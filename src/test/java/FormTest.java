import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormTest extends BaseTest {

    FormPage formPage;
    File file;

    @BeforeEach
    public void testSetup() {
        formPage = new FormPage(driver);
        file = new File("src/main/resources/file.txt");
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
    }


    @Test
    void shouldValidateForm() {
        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("jan.kowalski@test.com")
                .selectRandomGender()
                .setAge(27)
                .selectRandomExperience()
                .selectAutomationTesterProfession()
                .selectContinent("europe")
                .selectSeleniumCommands("switch-commands")
                .selectSeleniumCommands("wait-commands")
                .uploadFile(file)
                .sendForm();
        assertThat(formPage.getValidationMessage()).isEqualTo("Form send with success");
    }
}
