package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NtripHelper extends HelperBase{

    public NtripHelper(WebDriver wd){
        super(wd);
    }
    public void addBasePoint(){
        click(By.xpath("//div/div/button/span"));
    }
}
