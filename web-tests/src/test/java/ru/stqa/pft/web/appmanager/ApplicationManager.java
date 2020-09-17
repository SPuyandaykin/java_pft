package ru.stqa.pft.web.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private MountpointHelper mountpointHelper;
    private SettingHelper settingHelper;
    private NtripHelper ntripHelper;
    public String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (browser.equals(BrowserType.FIREFOX)){
//            System.setProperty("webdriver.gecko.driver", "C:\\Tools\\drivers\\geckodriver.exe");
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)){
//            System.setProperty("webdriver.chrome.driver", "C:\\Tools\\drivers\\chromedriver.exe");
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
//            System.setProperty("webdriver.ie.driver", "C:\\Tools\\drivers\\IEDriverServer.exe");
            wd = new InternetExplorerDriver();
        }


        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));

        sessionHelper       = new SessionHelper(wd);
        navigationHelper    = new NavigationHelper(wd);
        mountpointHelper    = new MountpointHelper(wd);
        settingHelper       = new SettingHelper(wd);
        ntripHelper         = new NtripHelper(wd);

        sessionHelper.login(properties.getProperty("web.userLogin"), properties.getProperty("web.userPass"));
        getSettingHelper().changeLanguage("US");
    }

    public void stop() {
//        sessionHelper.logout();
//        wd.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper(){
        return sessionHelper;
    }

    public MountpointHelper getMountpointHelper(){
        return mountpointHelper;
    }

    public SettingHelper getSettingHelper() { return settingHelper; }

    public NtripHelper getNtripHelper() {return ntripHelper;}
}

