package org.test.questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeResponseQuestion implements Question<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeResponseQuestion.class);

    @Override
    @Step("{0} verifica el código de respuesta de la petición")
    public Integer answeredBy(Actor actor) {
        int statusCode = SerenityRest.lastResponse().statusCode();
        LOGGER.info("El código de respuesta obtenido es: {}", statusCode);
        return statusCode;
    }

    public static CodeResponseQuestion codeResponseQuestion() {
        return new CodeResponseQuestion();
    }
}
