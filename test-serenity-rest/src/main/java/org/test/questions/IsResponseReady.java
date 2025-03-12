package org.test.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.rest.SerenityRest;

public class IsResponseReady implements Question<Boolean> {

    public static IsResponseReady isReady() {
        return new IsResponseReady();
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse() != null && SerenityRest.lastResponse().statusCode() == 200;
    }
}