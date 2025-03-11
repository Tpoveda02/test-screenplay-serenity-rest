package org.test.interations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetRequest extends RestInteraction {

    private String resource;

    public GetRequest(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String fullUrl = as(actor).resolve(resource);
        rest().log().all().get(fullUrl).then().log().all();
    }

    public static GetRequest resource(String resource) {
        return instrumented(GetRequest.class, resource);
    }
}