package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {

    private WebDriver driver;
    private JavascriptExecutor js;

    public HighlightElement(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String ID) {
        WebElement webElement = driver.findElement(By.id(ID));
        return webElement;
    }

    public void highlightElement(WebElement element, int duration) throws InterruptedException {
        String original_style = element.getAttribute("style");

        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (duration > 0) {
            Thread.sleep(duration * 1000);
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    element,
                    "style",
                    original_style);
        }
    }

    public static void highlightElement(WebDriver driver, WebElement element) {

        JavascriptExecutor javascript = (JavascriptExecutor) driver;

        javascript.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid black;');", element);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }
        javascript.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }
}
