package ui.pages;

import static com.codeborne.selenide.Selenide.open;
import static ui.pages.elements.Input.setValueInput;

public class ProjectPage {

    public void openProjectPage(){
        open("/projects");
    }

    public void clickCreateNewProjectButton(){
        clickButton("Create new project");
    }

    public void create(){
        setValueInput("For example:Web Application","project");
        setValueInput("For example:WA","DEMO");
        clickButton("Create new project");
    }
}
