package stepdefinitions;

import io.cucumber.java.en.When;

import static org.test.tasks.PostService.postService;

public class PostStepDefinition extends SetService{
    @When("Configura la petición a consumir con el recurso {string} con el cuerpo")
    public void configuraLaPeticiónAConsumirConElRecursoConElCuerpo(String resource, io.cucumber.datatable.DataTable dataTable) {
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
                postService()
                .withResource(resource)
                .withBody(requestBody)
        );
    }
}
