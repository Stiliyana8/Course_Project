package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;

import java.io.IOException;

public class UnsuccessfulLoginTest extends TestUtil {

    @DataProvider(name = "wrongUsersList")
    public static Object[][] readWrongUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/wrong.users.csv");
    }

    @Test(dataProvider = "wrongUsersList")
    public void UnsuccessfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);
        loginPage.tryToLogin(userName, password);
    }
}
