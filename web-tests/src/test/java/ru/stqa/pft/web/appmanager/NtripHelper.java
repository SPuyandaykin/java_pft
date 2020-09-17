package ru.stqa.pft.web.appmanager;

import org.testng.Assert;
import ru.stqa.pft.web.appmanager.ntrip.NtripServerHelper;
import org.openqa.selenium.WebDriver;

public class NtripHelper extends HelperBase  {

    private NtripServerHelper ntripServerHelper;

    public NtripHelper(WebDriver wd){
        super(wd);
        ntripServerHelper = new NtripServerHelper(wd);
    }

    public void addNtripServer(String name){

        if(isNtripServerExists(name))
            return;

        addNtripServerButton();
        ntripServerHelper.createNtripBaseSource(name);
    }

    private void addNtripServerButton(){
        clickButton("button__add");
    }

    public boolean isNtripServerExists(String name){
        return checkIsTableCellWithTextsExists(name);
    }

    public void deleteNtripServer(String name){
        if(!isNtripServerExists(name)) {
            Assert.fail("Server with name '"+name+"' doesn't exist");
            return;
        }

        selectNtripServerByName(name);
        ntripServerHelper.deleteNtripBaseSource();
    }

    private void selectNtripServerByName(String name){
        clickTableRawByCellText(name);
    }

}
