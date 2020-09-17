package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }

    protected void click(By locator){
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        wd.findElement(locator).click();
    }

    protected void typeTextEdit(String dataTestId, String text){
        By locator = By.cssSelector("input[data-test='"+ dataTestId +"']");
        typeTextByLocator(locator, text);
    }

    protected String getTextEdit (String dataTestId){
        By locator = By.cssSelector("input[data-test='"+ dataTestId +"']");
        return getTextByLocator(locator);
    }

    protected String getTextByLocator(By locator){

        if(isElementPresent(locator))
            return wd.findElement(locator).getAttribute("value");

        return "";
    }

    protected void typeTextArea(String dataTestId, String text){
        By locator = By.cssSelector("textarea[data-test='"+ dataTestId +"']");
        typeTextByLocator(locator, text);
    }

    protected void clickMenuNode (String dataTestId){
        By locator = By.cssSelector("mat-expansion-panel-header[data-test='"+dataTestId+"']");
        click(locator);
    }

    protected void clickToOpenDropDownList (String dataTestId){
        By locator = By.cssSelector("mat-select[data-test='"+dataTestId+"']");
        click(locator);
    }

    protected void clickMenuItem (String dataTestId){
        By locator = By.cssSelector("a[data-test='"+dataTestId+"']");
        click(locator);
    }

    protected void selectDropDownListItem (String itemName){
        By locator = By.xpath("//span[contains(text(), '" + itemName + "')]");
        click(locator);
    }

    protected void typeTextByLocator(By locator, String text){
        if (text != null) {
 //           String existingText = wd.findElement(locator).getAttribute("value");
            String existingText = getTextByLocator(locator);
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }



    protected boolean clickTableRawById (String dataTestId){
        if(!checkIsTableRawByID(dataTestId))
            return false;

        By locator = By.cssSelector("tr[data-test='"+dataTestId+"']");
        click(locator);

        return true;
    }

    protected void clickTableRawByIndex (int index){ ;
        By locator = By.cssSelector("tr[data-test^='object__connection']"); //hardcoded
        click(locator);
    }

    protected void clickElementByText (String text){ ;
        By locator = By.xpath("//div[contains(text(), '" + text + "')]");
        click(locator);
    }

    protected void clickTableRawByCellText (String cellText){ ;
        By locator = By.xpath("//app-base-entity-table-column[contains(text(), '" + cellText + "')]");
        click(locator);
    }

    public static boolean isAlertPresent(WebDriver wd){
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e){
            return false;
        }
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean checkIsElementWithTextsExists(String name) {
        return isElementPresent(By.xpath("//div[contains(text(), '" + name + "')]"));
    }

    protected boolean checkIsTableRawByID(String dataTestId) {
        return isElementPresent(By.cssSelector("tr[data-test='"+dataTestId+"']"));
    }

    protected boolean checkIsTableCellWithTextsExists(String name) {
        return isElementPresent(By.xpath("//app-base-entity-table-column[contains(text(), '" + name + "')]"));
    }

    public boolean refresh()
    {

        boolean executedActionStatus = false;
        try{

            ((JavascriptExecutor)wd).executeScript("document.location.reload()");

            Thread.sleep(2000);
            executedActionStatus = true;
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        return executedActionStatus;
    }

    public void clickButton(String dataTestAttribute){
        By locator = By.cssSelector("button[data-test='"+dataTestAttribute+"']");
        click(locator);
    }

    protected void confirmationWindow (String whatToDo){
        By locator = By.xpath("//span[contains(text(), '" + whatToDo + "')]");
        click(locator);
    }

    protected boolean isPageHasTitle(String titleText){
        return isElementPresent(By.xpath("//span[contains(text(), '" + titleText + "')]"));
    }

    protected void saveChanges(){
        clickButton("button__save");
    }

    protected void deleteCurrentObject(){
        clickButton("button__delete");
        confirmationWindow("YES");
    }

    protected void editCurrentObject(){
        clickButton("button__edit");
    }

    protected void selectCurrentObject(){
        clickButton("button__select");
    }
}
