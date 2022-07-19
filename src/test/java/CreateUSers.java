import create.CreateUserRequestBody;
import create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUSers {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void createNewMaleUSer(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("male").build();

        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);
    }

    @Test
    public void createNewFemaleUSer(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("female").build();

        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);
    }
}
