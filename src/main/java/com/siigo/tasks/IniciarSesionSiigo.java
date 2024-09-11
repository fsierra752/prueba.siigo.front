package com.siigo.tasks;

import com.siigo.interactions.ToWait;
import com.siigo.models.DatosLoginUsuarioModel;
import com.siigo.pages.LoginSiigo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static com.siigo.pages.LoginSiigo.*;

public class IniciarSesionSiigo implements Task {

    private final List<DatosLoginUsuarioModel> datosLoginUsuarioModelList;

    private final LoginSiigo loginSiigo;

    public IniciarSesionSiigo(List<DatosLoginUsuarioModel> datosLoginUsuarioModelList, LoginSiigo loginSiigo) {
        this.datosLoginUsuarioModelList = datosLoginUsuarioModelList;
        this.loginSiigo = loginSiigo;
    }

    public static Performable conLasCredenciales(List<DatosLoginUsuarioModel> datosLoginUsuarioModels, LoginSiigo loginSiigo) {
        return Tasks.instrumented(IniciarSesionSiigo.class, datosLoginUsuarioModels, loginSiigo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        loginSiigo.enterUsername(datosLoginUsuarioModelList.get(0).getUser());
        actor.attemptsTo(
                Enter.theValue(datosLoginUsuarioModelList.get(0).getUser()).into(INPUT_USER_NAME),
                Enter.theValue(datosLoginUsuarioModelList.get(0).getPassword()).into(INPUT_USER_PASSWORD),
                Click.on(BTN_INGRESAR),
                ToWait.unMomento(5));
    }
}
