import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }
}
