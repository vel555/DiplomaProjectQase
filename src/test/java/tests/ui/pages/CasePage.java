package tests.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CasePage extends BasePage {

    private final SelenideElement CREATE_CASE_BUTTON = $x("//span[text() = 'Case']");
    private final SelenideElement CASE_NAME_INPUT = $("#title");
    private final SelenideElement SAVE_BUTTON = $x("//span[text() = 'Save']");
    private final SelenideElement RECEIVE_CASE_NAME = $x("//div[@class = 'YkyiUm t1vo_q']");
    private final SelenideElement ADD_STEP_BUTTON = $x("//span[text() = ' Add step']");
    private final SelenideElement DESCRIPTION = $x("//div[@class='ProseMirror toastui-editor-contents']/p");

    @Step("Create new case")
    public void createNewCase() {
        CREATE_CASE_BUTTON.click();
    }

    @Step("Enter case name: {name}")
    public void inputCaseName(String name) {
        CASE_NAME_INPUT.sendKeys(name);
    }

    @Step("Click create case")
    public void createCase() {
        SAVE_BUTTON.shouldBe(visible).click();
    }

    @Step("Receive case name(actual)")
    public String receiveCaseName() {
        return RECEIVE_CASE_NAME.getText();
    }

    @Step("Add step")
    public void fillDescription() {
        DESCRIPTION.sendKeys("Description");  //CaseBuilder.getAllFields().getDescription()
    }

    @Step("Add step")
    public void addStep() {
        ADD_STEP_BUTTON.shouldBe(visible).click();
    }


}
