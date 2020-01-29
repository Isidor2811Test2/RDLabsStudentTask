package steps;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;


import java.time.Duration;

@Getter
@Slf4j
public class EmployeeTimeSheetsSteps extends DefaultStepsData {

    @Step
    public void searchByEmployeeName(String name) {
        getDriver().switchTo().frame(0);
        employeeTimeSheetsPage.getSearchInputField().waitUntilEnabled().click();
        employeeTimeSheetsPage.getSearchInputField().clear();
        log.info("Searching by name: " + name);
        employeeTimeSheetsPage.getSearchInputField().sendKeys(name);
    }


    @Step
    public String getTextFromAutoCompleteNameField() {
        String text = employeeTimeSheetsPage.getEmployeeNameAutoCompleteElement().withTimeoutOf(Duration.ofSeconds(5)).waitUntilVisible().getText();
        String name = text.substring(0, text.length() - 5);
        getDriver().switchTo().defaultContent();
        return name;
    }
}
