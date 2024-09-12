package com.siigo.tasks;

import com.siigo.pages.MenuHorizontalCrearPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class MenuHorizontal implements Task {

    private MenuHorizontalCrearPage menuHorizontalCrearPage;

    private final String opcSubmenu;

    public MenuHorizontal(String opcSubmenu) {
        this.opcSubmenu = opcSubmenu;
    }

    public static Performable botonCrearConOpcionSubmenu(String opcSubmenu) {
        return Tasks.instrumented(MenuHorizontal.class, opcSubmenu);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        menuHorizontalCrearPage.botonMasCrear(opcSubmenu);
    }
}
