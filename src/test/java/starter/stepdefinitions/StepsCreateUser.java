package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;

public class StepsCreateUser {

    protected Map<String, Object> map = new HashMap<String, Object>();

    @Given("El usuario envía el {string} y el {string} del usuario a actualizar")
    public void elUsuarioEnvíaElYElDelUsuarioAActualizar(String name, String job) {
        map.put("name", name);
        map.put("job", job);
        given()
                .contentType(ContentType.JSON)
                .body(map);
    }

    @When("Se accede a la {string} de la api")
    public void seAccedeALaDeLaApi(String url) {
        when().post(url);

    }

    @And("Se valida el esquema json sea correcto")
    public void seValidaElEsquemaJsonSeaCorrecto() {
        then().statusCode(201);
    }

    @Then("El estado de la solicitud update es SC_OK")
    public void elEstadoDeLaSolicitudUpdateEsSC_OK() {

        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(201);
    }
}
