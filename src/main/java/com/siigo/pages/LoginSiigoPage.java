package com.siigo.pages;

import com.siigo.interactions.EsperarInteraction;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSiigoPage extends PageObject {

    private WebDriver driver;

    public LoginSiigoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement pagina = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
        WebElement parentElement = driver.findElement(By.className("login"));
        WebElement imputName = parentElement.findElement(By.id("username"));
        imputName.click();
        imputName.sendKeys(username);
        EsperarInteraction.unMomento(1);
    }

    public void enterPassword(String password) {
        WebElement parentElement = driver.findElement(By.className("login"));
        WebElement imputPassword = parentElement.findElement(By.name("password-input"));
        imputPassword.click();
        imputPassword.sendKeys(password);
        EsperarInteraction.unMomento(1);
    }

    public void clicBotonIngresar() {
        WebElement parentElement = driver.findElement(By.className("login"));
        WebElement btnIngresar = parentElement.findElement(By.id("login-submit"));
        btnIngresar.click();
    }

}
