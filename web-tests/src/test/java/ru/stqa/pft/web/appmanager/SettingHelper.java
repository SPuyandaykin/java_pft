package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SettingHelper extends HelperBase{

    public SettingHelper (WebDriver wd){
        super(wd);
    }

    public void changeLanguage (String language) {

        if(language.equals(getCurrentLanguage()))
            return;

        click(By.xpath("//app-language-selector/button/span"));

        if(language.equals("US"))
            click(By.xpath("//div[@class='mat-menu-content']/button/em"));
        else
            click(By.xpath("//div[@class='mat-menu-content']/button[2]/em"));

//        Assert.assertEquals(getCurrentLanguage(), language);
    }

    public String getCurrentLanguage (){
        String str = wd.findElement(By.xpath("//app-language-selector/button/span/em")).getAttribute("class");
        if(str.equals("famfamfam-flags us"))
            return "US";
        else if (str.equals("famfamfam-flags ru"))
            return "RU";
        else {
            Assert.fail("Unknown language settings");
            return "";
        }
    }
}
