package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private NtripHelper ntripHelper;

    public void init(){

//    System.setProperty("webdriver.gecko.driver", "C:\\Tools\\drivers\\geckodriver.exe");
//    driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\drivers\\chromedriver.exe");
        wd = new ChromeDriver();

        wd.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        wd.get("https://webdemo.javad.com");

        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        ntripHelper = new NtripHelper(wd);

        sessionHelper.login();

    }

    public void stop() {
        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper(){
        return sessionHelper;
    }

    public NtripHelper getNtripHelper(){
        return ntripHelper;
    }
}

