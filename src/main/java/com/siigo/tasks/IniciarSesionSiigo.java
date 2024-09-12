package com.siigo.tasks;

import com.siigo.interactions.Esperar;
import com.siigo.models.DatosLoginUsuarioModel;
import com.siigo.pages.LoginSiigo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

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
        loginSiigo.enterPassword(datosLoginUsuarioModelList.get(0).getPassword());
        loginSiigo.clicBotonIngresar();
        Esperar.unMomento(5);
    }
}
