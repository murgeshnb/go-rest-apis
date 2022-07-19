package integrationTests;

import create.CreateUserRequestBody;
import create.response.UpdatedUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;

public class UserTests {

    private UserService userService;

    @BeforeClass
    public void beforeClass(){
        userService =new UserService();
    }

    @Test
    public void shouldCreateAndGetUser(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();

        //Act
        int id = userService.createUser(createUserRequestBody).getId();

        //Assert
        userService.getUserOnId(id).assertUSer(createUserRequestBody);
    }

    @Test
    public void shouldDeleteUser(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();

        //Act
        int id = userService.createUser(createUserRequestBody).getId();
        int statusCode = userService.deleteUser(id);

        //Assert
        Assert.assertEquals(statusCode,204);

        userService.getUserExpectingError(id)
                .asserError(404,"Resource not found");
    }

    @Test
    public void shouldCreateAndUpdateUser(){
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().gender("male").build();
        CreateUserRequestBody updateRequestBody = new CreateUserRequestBody.Builder().name("Tenali 123").build();

        //Act
        int id = userService.createUser(createUserRequestBody).getId();
        UpdatedUserResponse updatedUserResponse = userService.getUpdatedUserDetails(updateRequestBody, id);

        //Assert
        updatedUserResponse.assertUser(updateRequestBody);

    }

}
