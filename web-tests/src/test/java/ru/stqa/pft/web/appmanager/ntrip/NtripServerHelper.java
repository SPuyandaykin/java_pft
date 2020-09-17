package ru.stqa.pft.web.appmanager.ntrip;

import org.openqa.selenium.WebDriver;
import ru.stqa.pft.web.appmanager.HelperBase;

public class NtripServerHelper extends HelperBase {

    public NtripServerHelper(WebDriver wd){
        super(wd);
    }

    public void setServerName(String name) {
        typeTextEdit("input__name", name);
    }

    public void setServerIdentifier(String serverID) {
        typeTextEdit("input__identifier", serverID);
    }

    public void setServerCountyCode(String countryCode) {
        typeTextEdit("input__countryCode", countryCode);
    }

    public void setServerLatitude(String latitude) {
        typeTextEdit("input__latitude", latitude);
    }

    public void setServerLongitude(String longitude) {
        typeTextEdit("input__longitude", longitude);
    }

    public void setServerAltitude(String altitude) {
        typeTextEdit("input__altitude", altitude);
    }

    public void setServerAntenna(String serverAntenna) {
//        Select select = new Select(wd.findElement(By.cssSelector("mat-select[data-test='input__antennaModel']")));
//        select.selectByVisibleText(serverAntenna);
        clickToOpenDropDownList("input__antennaModel");
        selectDropDownListItem(serverAntenna);
    }

    public void setServerAntennaInput(String antennaInput) {
        clickToOpenDropDownList("input__antennaInput");
        selectDropDownListItem(antennaInput);
    }

    public void createNtripBaseSource(String name) {

        setServerName(name);
        setServerIdentifier(name+"_ID");
        setServerCountyCode("RU");

        setServerAntenna("JAVGRANT_G3");
        setServerAntennaInput("External");

        setServerLatitude("55,79867471");
        setServerLongitude("37,52067727");
        setServerAltitude("385,82949");

        saveChanges();
    }

    public void deleteNtripBaseSource(){
        deleteCurrentObject();

    }

}
