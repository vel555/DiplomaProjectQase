package ui.pages.elements;

import static com.codeborne.selenide.Selenide.$x;

public class Button {

    public void clickButton(String text){
        $x("//button//span[text()='"+text+"']").click();
    }
}
