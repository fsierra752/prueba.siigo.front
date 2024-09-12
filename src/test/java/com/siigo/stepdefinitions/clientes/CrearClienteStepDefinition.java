package com.siigo.stepdefinitions.clientes;

import com.siigo.models.DatosLoginUsuarioModel;
import com.siigo.pages.LoginSiigoPage;
import com.siigo.services.SetUp;
import com.siigo.tasks.IniciarSesionSiigo;
import com.siigo.tasks.MenuHorizontal;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import java.io.IOException;

import static com.siigo.utils.Access.URL_SIIGO;
import static com.siigo.utils.Dictionary.DATOS_LOGIN;
import static com.siigo.utils.UtilsCSV.obtenerDatosPrueba;

public class CrearClienteStepDefinition extends SetUp {

    private DatosLoginUsuarioModel datosLoginUsuarioModel;
    protected Actor actor;
    private LoginSiigoPage loginSiigo;

    @Before()
    public void setup(){
        setupGeneral();
        actor = Actor.named("Analista");
        actor.can(BrowseTheWeb.with(webDriver));
        loginSiigo = new LoginSiigoPage(webDriver);
    }

    @Dado("^que se ingresa a pagina siigo como \"([^\"]*)\"$")
    public void queSeIngresaAPaginaSiigoComo(String usuario) throws IOException {
        actor.attemptsTo(Open.url(URL_SIIGO));
        datosLoginUsuarioModel = new DatosLoginUsuarioModel(obtenerDatosPrueba(DATOS_LOGIN, usuario));
        actor.attemptsTo(IniciarSesionSiigo.conLasCredenciales(datosLoginUsuarioModel.getLstUsuarios(), loginSiigo));
    }

    @Cuando("^navegue al menu crear en la opcion \"([^\"]*)\"$")
    public void navegueAlMenuCrearEnLaOpcion(String opcSubmenu) {
        actor.attemptsTo(MenuHorizontal.botonCrearConOpcionSubmenu(opcSubmenu));
    }

    @Cuando("^envie la informacion solicitada de manera correcta$")
    public void envieLaInformacionSolicitadaDeManeraCorrecta() {

    }

    @Entonces("^verifico que el estado del nuevo cliente es \"([^\"]*)\"$")
    public void verificoQueElEstadoDelNuevoClienteEs(String arg1) {

    }



}
