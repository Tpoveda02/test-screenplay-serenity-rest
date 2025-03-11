package stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static org.test.utils.Constants.ACTOR;

public class SetService {
    protected  static final Actor actor = new Actor(ACTOR);
    protected void setService(String URL){
        actor.can(CallAnApi.at(URL));
    }
}
