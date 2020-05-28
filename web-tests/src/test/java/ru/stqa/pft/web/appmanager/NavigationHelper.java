package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd){
        super(wd);
    }

    public void gotoNtripPage(){
        click(By.cssSelector(".ng-star-inserted:nth-child(2) > .mat-card .mat-caption"));
    }
}
