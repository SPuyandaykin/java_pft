package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.web.data.LoginData;

public class SessionHelper extends HelperBase {

    public SessionHelper (WebDriver wd){
        super(wd);
    }

    public void login(String login, String pass){
        click(By.xpath("//app-tenant-card[2]/mat-card/mat-card-actions/button"));
        typeTextByLocator(By.name("userNameOrEmailAddress"), login);
        typeTextByLocator(By.name("password"), pass);
        click(By.id("LoginButton"));
    }

    public void logout(){
        click(By.xpath("//mat-toolbar/button/span/mat-icon"));
        click(By.xpath("//mat-icon"));
        click(By.xpath("//div[@id='cdk-overlay-0']/div/div/button[2]"));
    }

}
