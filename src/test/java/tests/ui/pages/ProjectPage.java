package tests.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.api.pojos.reqest.project.CreateProjectRequest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.ui.pages.elements.Button.clickButton;
import static tests.ui.pages.elements.Input.setValueInput;

public class ProjectPage extends BasePage {

    private final SelenideElement PROJECT_NAME_INPUT = $("#project-name");
    private final SelenideElement PROJECT_CODE_INPUT = $("#project-code");
    private final SelenideElement PROJECT_TEXT = $("h1[class=uA6zAY]");
    private final SelenideElement CREATE_NEW_PROJECT_BUTTON = $x("//span[text() = 'Create new project']");
    private final SelenideElement CREATE_PROJECT_BUTTON = $x("//span[text() = 'Create project']");
    private final SelenideElement RECEIVE_PROJECT_NAME = $("a[class = cx2QU4]");
    private final SelenideElement PROJ_NAME = $(".cx2QU4");
    private final SelenideElement PROJ_ERROR = $x("//div[text()='The code must be at least 2 characters.']");
    private final SelenideElement DELETE_BUTTON = $x("//div[@data-testid = 'remove']");
    private final SelenideElement DELETE_PROJECT_BUTTON = $x("//span[text() = 'Delete project']");
    private final ElementsCollection DOTS_BUTTON = $$x("//span[@class = 'qc0jO1']");


    public void openProjectPage(){
        open("/projects");
    }

    public void clickCreateNewProjectButton(){
        clickButton("Create new project");
    }


    public void create(CreateProjectRequest project){
        setValueInput("For example:Web Application","project");
        setValueInput("For example:WA","DEMO");
        clickButton("Create new project");
    }
    @Step("Project title is visible")
    public void projectPageIsOpened() {
        PROJECT_TEXT.shouldHave(text("Projects"));
    }
    @Step("Create new project")
    public void createNewProject() {
        CREATE_NEW_PROJECT_BUTTON.shouldBe(visible).click();
    }
    @Step("Enter project name: {name}")
    public void inputProjectName(String name) {
        PROJECT_NAME_INPUT.sendKeys(name);
    }
    @Step("Click create project")
    public void createProject() {
        CREATE_PROJECT_BUTTON.click();
    }
    @Step("Click Delete button")
    public void deleteButton() {
        DELETE_BUTTON.shouldBe(visible).click();
    }
    @Step("Click Delete project button")
    public void deleteProject() {
        DELETE_PROJECT_BUTTON.shouldBe(visible).click();
    }
    @Step("Assert that project deleted")
    public void assertThatProjectDeleted() {
        open("/projects");
        PROJ_NAME.shouldBe(not(visible));
    }
    @Step("Click Dots")
    public void clicDots() {
        DOTS_BUTTON.get(5).click();
    }

}
