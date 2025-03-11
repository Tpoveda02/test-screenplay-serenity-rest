package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.test.questions.CodeResponseQuestion;

import static org.hamcrest.CoreMatchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.test.utils.Constants.WEB_URL;
import static org.test.tasks.GetService.getService;

public class GetStepDefinition extends SetService{

    @Given("Un usuario obtiene la baseUrl de la api")
    public void unUsuarioObtieneLaBaseUrlDeLaApi() {
        OnStage.setTheStage(new OnlineCast());
        setService(WEB_URL);
    }

    @When("Configura la petición a consumir con el recurso {string}")
    public void configuraLaPeticiónAConsumirConElRecurso(String resource) {
        actor.attemptsTo(
                getService().withResource(resource)
        );

    }

    @Then("debería visualizar el estado de dicha petición")
    public void deberíaVisualizarElEstadoDeDichaPetición() {
        actor.should(
                seeThat("El código respuesta",
                        CodeResponseQuestion.codeResponseQuestion(),
                        equalTo(SC_OK)
                        )
        );
    }
}
