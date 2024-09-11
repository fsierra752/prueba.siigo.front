package com.siigo.services;

import net.serenitybdd.screenplay.Actor;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.siigo.utils.Access.RUTA_DRIVERS;
import static com.siigo.utils.Dictionary.ACTOR_NAME;
import static com.siigo.utils.enums.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;


public class SetUp {
    protected final Actor actor = Actor.named(ACTOR_NAME);
    protected WebDriver webDriver;

    protected void setupGeneral(){
        setupLog4j();
        System.setProperty("webdriver.chrome.driver", RUTA_DRIVERS);
        webDriver = new ChromeDriver(configurarChrome());
    }

    protected ChromeOptions configurarChrome() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1.0);
        prefs.put("traceCategories", "browser,devtools.timeline,devtools");
        prefs.put("enableNetwork", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        return options;
}

    private void setupLog4j(){
        PropertyConfigurator.configure(LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
