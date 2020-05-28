package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.web.data.LoginData;

public class SessionHelper extends HelperBase {

    LoginData loginData;

    public SessionHelper (WebDriver wd){
        super(wd);
    }

    public void login(){
        loginData = new LoginData();
        click(By.xpath("//app-tenant-card[2]/mat-card/mat-card-actions/button"));
        type(By.name("userNameOrEmailAddress"), loginData.getLogin());
        type(By.name("password"), loginData.getPass());
        click(By.id("LoginButton"));
    }

}
