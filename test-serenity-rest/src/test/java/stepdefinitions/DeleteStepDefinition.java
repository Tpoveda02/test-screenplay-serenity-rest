package stepdefinitions;


import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.test.questions.IsResponseReady;

import static org.test.tasks.DeleteService.deleteService;


public class DeleteStepDefinition extends SetService{

    @When("Configura la petición a consumir con el id a eliminar{string}")
    public void configuraLaPeticiónAConsumirConElIdAEliminar(String resource) {
        actor.attemptsTo(
                deleteService().withResource(resource)
        );
    }

}
