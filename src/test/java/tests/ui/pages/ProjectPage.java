package tests.ui.pages;

import static com.codeborne.selenide.Selenide.open;
import static tests.ui.pages.elements.Input.setValueInput;

public class ProjectPage {

    public void openProjectPage(){
        open("/projects");
    }

    public void clickCreateNewProjectButton(){
        clickButton("Create new project");
    }

    private void clickButton(String createNewProject) {
    }

    public void create(){
        setValueInput("For example:Web Application","project");
        setValueInput("For example:WA","DEMO");
        clickButton("Create new project");
    }
}
