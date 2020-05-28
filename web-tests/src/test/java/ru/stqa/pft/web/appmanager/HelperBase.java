package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.*;

public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    protected void click(By locator){
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public static boolean isAlertPresent(WebDriver wd){
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e){
            return false;
        }
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
