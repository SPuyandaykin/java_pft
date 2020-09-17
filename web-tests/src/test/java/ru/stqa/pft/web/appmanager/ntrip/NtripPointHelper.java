package ru.stqa.pft.web.appmanager.ntrip;

import org.openqa.selenium.*;
import ru.stqa.pft.web.appmanager.HelperBase;

public class NtripPointHelper extends HelperBase {

    public NtripPointHelper(WebDriver wd){
        super(wd);
    }

    public void createNtripMountPoint(String pointName, String pointCorrection, String pointSource){
        setPointName(pointName);
        setPointDescription(pointName+ " point description");
        selectNtripMessageGroup(pointCorrection);
        selectNtripSourceByName(pointSource);
        saveChanges();
    }

    private void setPointName(String pointName){
        typeTextEdit("input__name", pointName);
    }

    private void setPointDescription(String pointDescription){
        typeTextArea("input__description", pointDescription);
    }

    public void deSelectNtripMessageGroup(String correction) {
        clickButton("button__deselect_messageGroup");
        selectNtripMessageGroup(correction);
    }

    private void selectNtripMessageGroup(String correction) {
        clickButton("button__select_messageGroup");
        foundCorrectionInListAndSelectIt(correction);
    }

    private void selectNtripSourceByIndex(int index){
        openWindowForSelectSource();
        clickTableRawByIndex(index);
        clickButton("button__select");
    }

    public void deleteSelectedPoint() {
        deleteCurrentObject();
    }

    public void changeSelectedSource(String sourceName) {
        editCurrentObject();
        openWindowForChangeSource();
        selectOrCreateSource (sourceName);
    }

    private void selectNtripSourceByName (String sourceName){
        openWindowForSelectSource();
        selectOrCreateSource (sourceName);
    }

    private void selectOrCreateSource (String sourceName){

        if(foundSourceInListAndSelectIt(sourceName)) {
            selectFilteredSource();
        }else{
            closeListWindow();
            createNewSource(sourceName);
//            foundSourceInListAndSelectIt(sourceName);
        }
    }

    private void closeListWindow() {
        clickButton("button__close");
    }

    private void createNewSource(String sourceName) {
        By locator = By.linkText("attach a new server");
        click(locator);
        // warning !!! there are not 'data-test' attributes in this window
    }

    private boolean foundSourceInListAndSelectIt(String sourceName){
        filterSource(sourceName);

        String dataId = "object__connection_"+sourceName;
        return clickTableRawById(dataId);
    }

    private void  foundCorrectionInListAndSelectIt(String sourceName){
        filterSource(sourceName);

        String dataId = "object__messageGroup_"+sourceName;
        clickTableRawById(dataId);

        selectFilteredSource();
    }

    private void filterSource(String sourceName){
        typeTextEdit("input__filter", sourceName);

    }

    private void selectFilteredSource(){
        selectCurrentObject();
    }

    private void openWindowForSelectSource(){
        clickButton("button__select_source");
    }

    private void openWindowForChangeSource(){
        clickButton("button__change_source");
    }

    public void changeSelectedPointName(String pointNameNew) {
        editCurrentObject();
        setPointName(pointNameNew);
        saveChanges();
    }

    public void changeSelectedPointCorrection(String correctionSet) {
        editCurrentObject();
        openWindowForChangeCorrection();
        foundCorrectionInListAndSelectIt(correctionSet);
        saveChanges();
    }

    private void openWindowForChangeCorrection() {
        clickButton("button__change_messageGroup");
    }

    public void changeSelectedPointAvailability(boolean pointPublish) {
//        editCurrentObject();
        setPointAvailability(pointPublish);

        editCurrentObject();
        String s = getTextEdit("input__name");
        saveChanges();
    }

    private boolean getPointCurrentAvailability() {
        By locator = By.cssSelector("button[data-test='button__conceal']");
        return isElementPresent(locator);
    }

    private void setPointAvailability(boolean pointPublish) {
        boolean isPublished = getPointCurrentAvailability();
        if(isPublished==pointPublish)
            return;

        if(pointPublish)
            clickButton("button__publish");
        else
            clickButton("button__conceal");

        confirmationWindow("YES");
    }
}

