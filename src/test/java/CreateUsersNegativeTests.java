import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersNegativeTests {

    @Test
    public void shouldNotCreateUserWithInvalidEmailID(){
        //Arrange
        String body=" \"name\": \"Tenali Ramakrishna\",\n"+" \"gender\": \"male\",\n"+" \"email\": \"tenali.ramakrishna8gmail.com\",\n";
        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

                //Aseert
                .statusCode(422);




    }
}
