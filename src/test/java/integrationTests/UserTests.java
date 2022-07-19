package integrationTests;

import create.CreateUserRequestBody;
import create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

public class UserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }

    @Test
    public void shouldCreateAndGetUser(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();

        //Act
        int id = usersClient.createUser(createUserRequestBody).getId();

        //Assert
        usersClient.getUserOnId(id).assertUSer(createUserRequestBody);
    }

}
