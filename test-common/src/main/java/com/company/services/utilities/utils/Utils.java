package com.company.services.utilities.utils;

import com.company.configuration.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public final class Utils {

    private Utils() {

    }

    public static void waitMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickJs(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance().getDriver();
        jse.executeScript("Arguments[0].click();", element);
    }

    /**
    * @param element is a web element to click with delay of 100 millis
    * */

    public static void clickJsMillis(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance().getDriver();
        jse.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
    }

    public static void dragAndDropJS(WebElement from, WebElement target) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance().getDriver();
        jse.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", from, target);
    }

    public static void clickHiddenElementJs(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance().getDriver();
        jse.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';", element);
    }

}
