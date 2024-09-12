package com.siigo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

public class EsperarInteraction implements Interaction {

    private int tiempo;
    public EsperarInteraction(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Awaitility.await().forever().pollInterval(tiempo, TimeUnit.SECONDS).until(() -> true);
    }
    public static EsperarInteraction unMomento(int tiempo) {
        return Tasks.instrumented(EsperarInteraction.class, tiempo);
    }


}
