import create.CreateUserRequestBody;
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
        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").gender("male").email("tenali.ramakrishna8gmail.com").status("active").build();
        //Act
        usersClient.createUser(createUserRequestBody)
                .then()
                .log().body()

                //Aseert
                .statusCode(422)
                .body("[0].field", Matchers.equalTo("email"))
                .body("[0].message", Matchers.equalTo("is invalid"));
        }
}
