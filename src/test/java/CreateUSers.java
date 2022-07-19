import create.CreateUserRequestBody;
import create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;

import static io.restassured.RestAssured.given;

public class CreateUSers {

    private UserService userService;

    @BeforeClass
    public void beforeClass(){
        userService =new UserService();
    }

    @Test
    public void createNewMaleUSer(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("male").build();

        //Act
        CreateUserResponse createUserResponse = userService.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);
    }

    @Test
    public void createNewFemaleUSer(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("female").build();

        //Act
        CreateUserResponse createUserResponse = userService.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);
    }
}
