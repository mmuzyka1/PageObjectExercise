import org.junit.jupiter.api.Test;
import pages.RowPage;
import pages.TablePage;

public class TableTest extends BaseTest {

    @Test
    void shouldPrintRows() {
        driver.get("http://www.seleniumui.moderntester.pl/table.php");

        TablePage tablePage = new TablePage(driver);
        for (RowPage mountain : tablePage.getMountains()) {
            if (mountain.validateHeight(4000) & mountain.validateCountry("Switzerland")) {
                mountain.printInfo();
            }
        }
    }
}
