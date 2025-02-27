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
    private final SelenideElement CASE_NAME = $x("//div[@class = 'YkyiUm t1vo_q']");
    private final SelenideElement RECEIVE_CASE_NAME = $x("//div[@class = 'YkyiUm t1vo_q']");
    private final SelenideElement ADD_STEP_BUTTON = $x("//span[text() = ' Add step']");
    private final SelenideElement DESCRIPTION = $x("//div[@class='ProseMirror toastui-editor-contents']/p");
    private final ElementsCollection ARROW_SELECT_OPTION = $$x("//div[@class = 'xKUpf_']");
    private final SelenideElement CHOOSE_STATUS = $x("//div[text() = 'Actual']");

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

    @Step("Assert that case {name} created")
    public void assertThatCaseCreated(String name) {
        CASE_NAME.shouldHave(text(name));
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

    @Step("Fill Status field")
    public void fillStatus() {
        ARROW_SELECT_OPTION.get(0).click();
        CHOOSE_STATUS.shouldBe(visible).click();
    }

    @Step("Fill Suite field")
    public void fillSuite(String text) {
        ARROW_SELECT_OPTION.get(1).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill Severity field")
    public void fillSeverity(String text) {
        ARROW_SELECT_OPTION.get(2).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill Priority field")
    public void fillPriority(String text) {
        ARROW_SELECT_OPTION.get(3).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill Type field")
    public void fillType(String text) {
        ARROW_SELECT_OPTION.get(4).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill Layer field")
    public void fillLayer(String text) {
        ARROW_SELECT_OPTION.get(5).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill isFlaky field")
    public void fillIsFlaky(String text) {
        ARROW_SELECT_OPTION.get(6).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill Behavior field")
    public void fillBehavior(String text) {
        ARROW_SELECT_OPTION.get(7).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

    @Step("Fill Automation status field")
    public void fillAutomationStatus(String text) {
        ARROW_SELECT_OPTION.get(8).click();
        $x("//div[text() = '" + text + "']").shouldBe(visible).click();
    }

}
