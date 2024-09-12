package com.siigo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuHorizontalCrearPage extends PageObject {

    public MenuHorizontalCrearPage() {
        super();
    }

    public void botonMasCrear(String opcSubmenu) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        // Esperar a que el elemento sea visible
        WebElement menuHorizontal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("btn-element size-m")));
        WebElement boton = menuHorizontal.findElement(By.id("header-create-button"));
        // Hacer clic en el elemento
        boton.click();
    }

}
