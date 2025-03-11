package org.test.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetRequest extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetRequest.class);
    private String resource;

    public GetRequest(String resource) {
        this.resource = resource;
    }

    @Override
    @Step("{0} realiza una solicitud GET al recurso {1}")
    public <T extends Actor> void performAs(T actor) {
        String fullUrl = as(actor).resolve(resource);
        LOGGER.info("Realizando solicitud GET a la URL: {}", fullUrl);
        rest().log().all().get(fullUrl).then().log().all();
    }

    public static GetRequest resource(String resource) {
        return instrumented(GetRequest.class, resource);
    }
}