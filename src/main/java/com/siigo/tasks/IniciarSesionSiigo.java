package com.siigo.tasks;

import com.siigo.interactions.EsperarInteraction;
import com.siigo.models.DatosLoginUsuarioModel;
import com.siigo.pages.LoginSiigoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.List;

public class IniciarSesionSiigo implements Task {

    private final List<DatosLoginUsuarioModel> datosLoginUsuarioModelList;

    private final LoginSiigoPage loginSiigo;

    public IniciarSesionSiigo(List<DatosLoginUsuarioModel> datosLoginUsuarioModelList, LoginSiigoPage loginSiigoPage) {
        this.datosLoginUsuarioModelList = datosLoginUsuarioModelList;
        this.loginSiigo = loginSiigoPage;
    }

    public static Performable conLasCredenciales(List<DatosLoginUsuarioModel> datosLoginUsuarioModels, LoginSiigoPage loginSiigoPage) {
        return Tasks.instrumented(IniciarSesionSiigo.class, datosLoginUsuarioModels, loginSiigoPage);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        loginSiigo.enterUsername(datosLoginUsuarioModelList.get(0).getUser());
        loginSiigo.enterPassword(datosLoginUsuarioModelList.get(0).getPassword());
        loginSiigo.clicBotonIngresar();
        EsperarInteraction.unMomento(5);
    }
}
