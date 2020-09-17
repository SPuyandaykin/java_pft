package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.web.appmanager.ntrip.NtripPointHelper;
import ru.stqa.pft.web.data.PointData;

import java.util.ArrayList;
import java.util.List;

public class MountpointHelper extends HelperBase{

    private NtripPointHelper ntripPointHelper;

    public MountpointHelper(WebDriver wd){

        super(wd);
        ntripPointHelper = new NtripPointHelper(wd);
    }

    public void addPointWithBaseNtripSource(String pointName, String pointCorrections, String pointSource){

        if(isMountpointExists(pointName))
            return;

        menuPointWithBaseNtripSource();
        ntripPointHelper.createNtripMountPoint(pointName, pointCorrections, pointSource);
    }

    private void menuPointWithBaseNtripSource(){
        clickButton("button__add");
        clickButton("button__add-base");
    }

    public boolean isMountpointExists(String name){
        return checkIsElementWithTextsExists(name);
    }

    public void modifyNtripCorrectionSource(String name, String correction){
        click(By.xpath("//div[@class='title']/div[contains(text(),name)]"));
        clickButton("button__edit");
        ntripPointHelper.deSelectNtripMessageGroup(correction);
        clickButton("button__save");

    }

    public int getMountpointsTotalNumber() {
        String s[] = wd.findElement(By.xpath("//div[@class='mat-paginator-range-label']")).getText().split(" ");
        int count = s.length;
        Assert.assertEquals(count,5);
        return Integer.parseInt(s[count-1]);
    }

    public int checkMountpointListItNotEmpty(){
        int number = wd.findElements(By.xpath("//app-mountpoint-list-item")).size();
        Assert.assertFalse(number==0);
        return number;
    }

    public NtripPointHelper getNtripPointHelper() {
        return ntripPointHelper;
    }

    public void selectPointFromListByIndex(int index) {
        Assert.assertTrue( (index <= checkMountpointListItNotEmpty() && (index!=0)), "index should be > 0 and < ListNumber" );
        click(By.xpath("//app-mountpoint-list-item["+Integer.toString(index)+"]"));

    }

    public String setHowManyPointToShow(int number){
        String currentUrl = wd.getCurrentUrl();

        return currentUrl;
    }

    public List<PointData> getAllPointsName() {
        int number = checkMountpointListItNotEmpty();
        List<PointData> pointsInfo = new ArrayList<PointData>();
        for(int i=1; i<=number; i++){
            WebElement we = wd.findElement(By.xpath("//app-mountpoint-list-item["+Integer.toString(i)+"]"));
            String name = we.findElement(By.className("name")).getText();
            pointsInfo.add(new PointData().withName(name));
        }
        return pointsInfo;

    }

    public void deletePointByName(String pointName) {
        if(!selectMountpointByName(pointName))
            return;

        ntripPointHelper.deleteSelectedPoint();
    }

    public void changePointSource(String pointName, String sourceName) {
        if(!selectMountpointByName(pointName))
            return;

        ntripPointHelper.changeSelectedSource(sourceName);
    }

    private boolean selectMountpointByName(String pointName){
        if(!isMountpointExists(pointName)) {
            Assert.fail("Point with name '" + pointName + "' doesn't exits");
            return false;
        }

        clickElementByText(pointName);
        return true;
    }

    public String getPointSourceInfo(String pointName) {
/*        By locator = By.xpath("//div[contains(text(), '" + pointName + "')]");
        WebElement we = wd.findElement(locator);

        // will make later
*/
        return "";
    }

    public void changeName(String pointName, String pointNameNew) {
        if(!selectMountpointByName(pointName)){
            Assert.fail("Point with name '" + pointName +"' doesn't exits");
            return;
        }

        ntripPointHelper.changeSelectedPointName(pointNameNew);
    }

    public void changeCorrectionSet(String pointName, String correctionSet) {
        if(!selectMountpointByName(pointName)){
            Assert.fail("Point with name '" + pointName +"' doesn't exits");
            return;
        }

        ntripPointHelper.changeSelectedPointCorrection(correctionSet);
    }

    public void changeAvailability(String pointName, boolean pointPublish) {
        if(!selectMountpointByName(pointName)) {
            Assert.fail("Point with name '" + pointName +"' doesn't exits");
            return;
        }

        ntripPointHelper.changeSelectedPointAvailability(pointPublish);
    }
}
