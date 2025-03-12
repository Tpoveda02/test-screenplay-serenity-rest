package org.test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.interactions.DeleteRequest;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteService implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteService.class);
    private String resource;

    public DeleteService withResource(String resource) {
        this.resource = resource;
        return this;
    }

    @Step("{0} Eliminar las mascotas #productName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está eliminando", resource);

        actor.attemptsTo(
                DeleteRequest.resource(resource)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static DeleteService deleteService() {
        return instrumented(DeleteService.class);
    }
}
