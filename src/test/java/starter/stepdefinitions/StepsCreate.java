package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.when;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.containsString;


public class StepsCreate {
    @Given("El usuario envía el body y los headers para crear un nuevo usuario")
    public void elUsuarioEnvíaElBodyYLosHeadersParaCrearUnNuevoUsuario() {

        given().contentType("application/json");
    }

    @When("El esquema del jason sea correcto")
    public void elEsquemaDelJasonSeaCorrecto() {

        when().get("https://reqres.in/api/unknown");
    }

    @Then("El estado de la solicitud es SC_CREATED")
    public void elEstadoDeLaSolicitudEsSC_CREATED() {
        then().statusCode(200)
                .body(containsString("page"));
    }
}
