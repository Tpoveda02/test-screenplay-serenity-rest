package org.test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.interactions.GetRequest;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetService implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetService.class);
    private String resource;

    public GetService withResource(String resource) {
        this.resource = resource;
        return this;
    }

    @Step("{0} obtener las mascotas #productName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está obteniendo la lista de '{}'", actor.getName(), resource);

        actor.attemptsTo(
                GetRequest.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
                );
    }

    public static GetService getService() {
        return instrumented(GetService.class);
    }
}