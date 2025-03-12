package org.test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.interactions.PutRequest;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutService implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(PutService.class);
    private String resource;
    private String requestBody;

    public PutService withResource(String resource) {
        this.resource = resource;
        return this;
    }

    public PutService withBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    @Step("{0} Actualizar la información de una mascota con el resource{1}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está actualizando una  mascota con el recurso '{}'", actor.getName(), resource);

        actor.attemptsTo(
                PutRequest.withResourceAndBody(resource, requestBody)
                        .with( requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(requestBody)
                                .relaxedHTTPSValidation()
                        )

        );


    }
    public static PutService putService () {
        return instrumented(PutService.class);
    }
}

