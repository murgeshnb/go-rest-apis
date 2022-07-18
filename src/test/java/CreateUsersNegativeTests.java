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
        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").gender("male").email("tenali.ramakrishna8gmail.com").status("active").build();
        //Act
        CreateUserErrorResponse[] negativeResponse = usersClient.createUserExpectingError(createUserRequestBody);


                //Aseert

//        assertEquals(negativeResponse.getStatusCode(),422);

        for (CreateUserErrorResponse responses:negativeResponse) {
            assertEquals(responses.getStatusCode(),422);

            responses.assertHasError("email","is invalid");
       //     negative.assertHasError("status","can't be blank");
        }

    //    negativeResponse.assertHasError("email","is invalid");

        }

        @Test
    public void shouldNotAllowToCreateUserWithBlankGender(){
            //Arrange
            CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Dasa").gender("").email("dasa@gmail.com").status("active").build();

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
        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Dasa").gender("male").email("dasa1@gmail.com").status("").build();

        //Act
        CreateUserErrorResponse[] negativeResponse = usersClient.createUserExpectingError(createUserRequestBody);

        //Assert
        for (CreateUserErrorResponse responses:negativeResponse) {
            responses.assertHasError("status","can't be blank");
        }
    }
}
