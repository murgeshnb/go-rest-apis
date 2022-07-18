import create.CreateUserRequestBody;
import create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

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
        String email= String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").email(email).gender("male").status("active").build();

        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);
    }

    @Test
    public void createNewFemaleUSer(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody createUserRequestBody = CreateUserRequestBody.builder().name("Raziya").gender("female").email(email).status("active").build();
        //Act
        CreateUserResponse createUserResponse = usersClient.createUser(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);

    }
}
