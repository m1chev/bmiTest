import net.calculator.CalculatorPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Browser;

public class Calculations {
    @BeforeClass
    public void setUp() {
        Browser.open("chrome", false);
        Browser.goToPage("https://www.calculator.net/bmi-calculator.html");
    }

    @DataProvider
    public Object[][] testData() {
        String[][] stringArray = {
                {"30", "true", "190", "80", "BMI = 22.2 kg/m2", "Normal"},
                {"25", "true", "170", "100", "BMI = 34.6 kg/m2", "Obese Class I"},
                {"40", "true", "170", "110", "BMI = 38.1 kg/m2", "Obese Class II"},
                {"40", "false", "180", "50", "BMI = 15.4 kg/m2", "Severe thinness"}
        };
        return stringArray;
    }

    @Test(dataProvider = "testData")
    public void calculatorTest(
            String age,
            String isMale,
            String height,
            String weight,
            String bmi,
            String category
    ) {
        CalculatorPage.testValue(
                age,
                isMale,
                height,
                weight,
                bmi,
                category
        );
    }

    @AfterClass
    public void tearDown() {
        Browser.quit();
    }
}
