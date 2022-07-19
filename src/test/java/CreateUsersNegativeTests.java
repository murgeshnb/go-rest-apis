import create.CreateUserRequestBody;
import create.response.CreateUserErrorResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import static org.testng.Assert.*;

public class CreateUsersNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void shouldNotCreateUserWithInvalidEmailID(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().email("agmail.com").build();

        //Act
        CreateUserErrorResponse[] negativeResponse = usersClient.createUserExpectingError(createUserRequestBody);

        //Aseert
        for (CreateUserErrorResponse responses:negativeResponse) {
            assertEquals(responses.getStatusCode(),422);
            responses.assertHasError("email","is invalid");
        }
    }

        @Test
    public void shouldNotAllowToCreateUserWithBlankGender(){
            //Arrange
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("").build();

            //Act
            CreateUserErrorResponse[] negativeResponse = usersClient.createUserExpectingError(createUserRequestBody);

            //Assert
            for (CreateUserErrorResponse responses:negativeResponse) {
                responses.assertHasError("gender","can't be blank, can be male or female");
            }
        }

    @Test
    public void shouldNotAllowToCreateUserWithBlankStatus(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().status("").build();

        //Act
        CreateUserErrorResponse[] negativeResponse = usersClient.createUserExpectingError(createUserRequestBody);

        //Assert
        for (CreateUserErrorResponse responses:negativeResponse) {
            responses.assertHasError("status","can't be blank");
        }
    }
}
