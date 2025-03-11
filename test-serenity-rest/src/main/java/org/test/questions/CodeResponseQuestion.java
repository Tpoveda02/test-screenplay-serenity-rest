package org.test.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;





public class CodeResponseQuestion implements Question<Integer> {
@Override
public Integer answeredBy(Actor actor){
    return SerenityRest.lastResponse().statusCode();
}

   public static CodeResponseQuestion codeResponseQuestion(){
    return new CodeResponseQuestion();
   }
}
