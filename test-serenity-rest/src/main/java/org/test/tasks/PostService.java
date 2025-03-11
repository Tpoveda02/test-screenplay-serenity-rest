package org.test.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.interactions.PostRequest;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostService implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);
    private String resource;
    private String requestBody;

    public PostService withResource(String resource) {
        this.resource = resource;
        return this;
    }

    public PostService withBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    @Step("{0} crea una nueva mascota con el recurso #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} está creando una nueva mascota con el recurso '{}'", actor.getName(), resource);

        actor.attemptsTo(
                PostRequest.withResourceAndBody(resource, requestBody)
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.JSON)
                                        .relaxedHTTPSValidation()
                        )
        );
    }

    public static PostService postService() {
        return instrumented(PostService.class);
    }
}