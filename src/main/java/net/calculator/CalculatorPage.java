package net.calculator;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class CalculatorPage {
    private static final By LOC_AGE= By.id("cage");
    private static final By LOC_IS_MALE= By.cssSelector("#csex1+span");
    private static final By LOC_IS_FEMALE= By.cssSelector("#csex2+span");
    private static final By LOC_HEIGHT = By.id("cheightmeter");
    private static final By LOC_WEIGHT = By.id("ckg");
    private static final By LOC_CALCULATE = By.cssSelector("input[alt='Calculate']");
    private static final By LOC_CATEGORY = By.cssSelector("#content > div.rightresult > div > font > b");
    private static final By LOC_BMI = By.cssSelector("div.bigtext>b");

    /**
     * Checks if the result from the calculator is correct by the given parameters
     *
     * @param age the age of the user
     * @param isMale the gender of the user
     * @param height the height of the user
     * @param weight the weight of the user
     * @param bmi the expected Body Mass Index of the user
     * @param category the expected category of the suer
     */
    public static void testValue(
            String age,
            String isMale,
            String height,
            String weight,
            String bmi,
            String category
    ) {
        Browser.driver.findElement(LOC_AGE).clear();
        Browser.driver.findElement(LOC_AGE).sendKeys(age);

        if (isMale.equals("true")) {
            Browser.driver.findElement(LOC_IS_MALE).click();
        } else {
            Browser.driver.findElement(LOC_IS_FEMALE).click();
        }

        Browser.driver.findElement(LOC_HEIGHT).clear();
        Browser.driver.findElement(LOC_HEIGHT).sendKeys(height);

        Browser.driver.findElement(LOC_WEIGHT).clear();
        Browser.driver.findElement(LOC_WEIGHT).sendKeys(weight);

        Browser.driver.findElement(LOC_CALCULATE).click();


        Assert.assertEquals(
                Browser.driver.findElement(LOC_CATEGORY).getText(),
                category
        );

        Assert.assertEquals(
                Browser.driver.findElement(LOC_BMI).getText(),
                bmi
        );
    }
}
