package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.test.tasks.GetService;

import static org.test.tasks.PostService.postService;
import static org.test.tasks.PutService.putService;
import static stepdefinitions.SetService.actor;


public class PutStepDefinitions  extends  SetService{
    @When("Configura la petición a consumir con el recurso {string} con el cuerpo para actualizar")
    public void configuraLaPeticiónAConsumirConElRecursoConElCuerpoParaActualizar(String resource, DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);

        String requestBody = "{"
                + "\"id\": " + data.get("id") + ","
                + "\"category\": {"
                + "  \"id\": " + data.get("categoryId") + ","
                + "  \"name\": \"" + data.get("categoryName") + "\""
                + "},"
                + "\"name\": \"" + data.get("name") + "\","
                + "\"photoUrls\": " + data.get("photoUrls") + ","
                + "\"tags\": ["
                + "  {"
                + "    \"id\": " + data.get("tagId") + ","
                + "    \"name\": \"" + data.get("tagName") + "\""
                + "  }"
                + "],"
                + "\"status\": \"" + data.get("status") + "\""
                + "}";

        actor.attemptsTo(
                putService()
                        .withResource(resource)
                        .withBody(requestBody)
        );


    }

}

