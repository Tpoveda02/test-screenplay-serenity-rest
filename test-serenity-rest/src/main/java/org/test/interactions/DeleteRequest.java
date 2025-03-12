package org.test.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class DeleteRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRequest.class);
    private String resource;

    public DeleteRequest(String resource) {
        this.resource = resource;
    }

    @Override
    @Step("{0} realiza una solicitud Delete al recurso {1}")
    public <T extends Actor> void performAs(T actor) {
        String fullUrl = as(actor).resolve(resource);
        LOGGER.info("Realizando solicitud Delete a la URL: {}", fullUrl);
        rest().log().all().delete(fullUrl).then().log().all();
    }

    public static DeleteRequest resource(String resource) {
        return instrumented(DeleteRequest.class, resource);
    }
}
