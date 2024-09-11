package com.siigo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;


public class LoginSiigo extends PageObject {

    private WebDriver driver;

    public LoginSiigo(WebDriver driver) {
        this.driver = driver;
    }


    private WebElement getShadowRootElement(String shadowHostSelector) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(shadowHostSelector)));
        System.out.println("Shadow Host: " + shadowHost);
        if (shadowHost == null) {
            throw new NoSuchElementException("No se encontró el elemento con el selector: " + shadowHostSelector);
        }
        //Usar JavaScript para obtener el shadowRoot
        WebElement shadowRoot = (WebElement) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].shadowRoot", shadowHost);
        System.out.println("Shadow Root: " + shadowRoot);
        return shadowRoot;
    }

    public WebElement getInputField() {
        WebElement shadowRoot = getShadowRootElement("input-atom#username");
        return shadowRoot.findElement(By.cssSelector("#username-input"));
    }

    public void enterUsername(String username) {
        WebElement inputElement = getInputField();
        inputElement.sendKeys(username);
    }

    public static final Target INPUT_USER_NAME = Target.the("Campo para ingresar usuario")
            .located(By.name("username-input"));

    public static final Target INPUT_USER_PASSWORD = Target.the("Campo para ingresar contraseña")
            .located(By.id("password"));

    public static final Target BTN_INGRESAR = Target.the("Boton ingresar a siigo")
            .located(By.id("login-submit"));

}
