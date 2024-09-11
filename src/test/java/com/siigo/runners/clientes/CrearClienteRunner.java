package com.siigo.runners.clientes;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/clientes/crear_clientes.feature",
        glue = "com\\siigo\\stepdefinitions\\clientes",
        snippets= SnippetType.CAMELCASE)
public class CrearClienteRunner {

}
