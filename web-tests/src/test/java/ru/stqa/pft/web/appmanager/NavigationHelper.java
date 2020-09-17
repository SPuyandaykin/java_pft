package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd){
        super(wd);
    }

    public void gotoHomePage(){
        if(isElementPresent(By.xpath("//mat-card-title[contains(text(),'Linked devices')]")))
            return;

        openMenuPanel();
        clickMenuItem("link__menu_Dashboard");

    }

    public void gotoMountpointsPage(){
        if(isPageHasTitle("Ntrip mountpoints"))
            return;

        openMenuPanel();
        clickMenuNode("link__menu_NTRIP");
        clickMenuItem("link__menu_NtripMountpoints");
    }

    public void gotoNtripsServerPage(){
        if(isPageHasTitle("Managed NTRIP server"))
            return;

        openMenuPanel();
        clickMenuNode("link__menu_NTRIP");
        clickMenuItem("link__menu_BaseSources");
    }

    public void openMenuPanel(){
        clickButton("button__hamburger");
    }

}
