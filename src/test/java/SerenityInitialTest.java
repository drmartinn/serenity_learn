import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.ResponseCode;
import task.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SerenityRunner.class)
public class SerenityInitialTest {
    private static final String BASIC_URL= "https://reqres.in/api";
    @Test
    public void getUsers(){
        Actor daniel = Actor.named("Daniel")
                .whoCan(CallAnApi.at(BASIC_URL));
        daniel.attemptsTo(
                GetUsers.fromPage(2)
        );
        daniel.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo(200))
        );
    }
}
