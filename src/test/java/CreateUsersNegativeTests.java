import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void shouldNotCreateUserWithInvalidEmailID(){
        //Arrange
        String body=" \"name\": \"Tenali Ramakrishna\",\n"+" \"gender\": \"male\",\n"+" \"email\": \"tenali.ramakrishna8gmail.com\",\n";
        //Act
        usersClient.createUser(body)
                .then()
                .log().body()

                //Aseert
                .statusCode(422)
        ;
          //      .body(".field", Matchers.equalTo("email"))
           //     .body(".message", Matchers.equalTo("is invalid"));
        ;
    }
}
