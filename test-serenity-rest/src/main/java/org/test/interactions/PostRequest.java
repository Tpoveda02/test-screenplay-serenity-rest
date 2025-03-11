package org.test.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostRequest.class);
    private String resource;
    private String requestBody;

    public PostRequest(String resource, String requestBody) {
        this.resource = resource;
        this.requestBody = requestBody;
    }

    @Override
    @Step("{0} realiza una solicitud POST al recurso {1} con el cuerpo {2}")
    public <T extends Actor> void performAs(T actor) {
        String fullUrl = as(actor).resolve(resource);
        
        LOGGER.info("Realizando solicitud POST a la URL: {}", fullUrl);
        LOGGER.info("Cuerpo de la solicitud: {}", requestBody);

        rest().log().all()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(fullUrl)
                .then().log().all();
    }

    public static PostRequest withResourceAndBody(String resource, String requestBody) {
        return instrumented(PostRequest.class, resource, requestBody);
    }
}