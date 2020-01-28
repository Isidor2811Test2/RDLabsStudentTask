package steps;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

@Getter
@Slf4j
public class EmployeeTimeSheetsSteps extends DefaultStepsData {

    @Step
    public void searchByEmployeeName(String name) throws InterruptedException {
        getDriver().switchTo().frame(0);
        employeeTimeSheetsPage.getSearchInputField().waitUntilEnabled().click();
        employeeTimeSheetsPage.getSearchInputField().clear();
        log.info("Searching by name: " + name);
        employeeTimeSheetsPage.getSearchInputField().sendKeys(name);

    }


    @Step
    public String getTextFromAutoCompleteNameField() {
        String text = employeeTimeSheetsPage.getEmployeeNameAutoCompleteElement().withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible().getText();
        text.trim();
        System.out.println(text + "Hello");
        getDriver().switchTo().defaultContent();
        return text;
    }
}
