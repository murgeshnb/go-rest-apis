import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
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
        
        String body=String.format(" \"name\": \"Tenali Ramakrishna\",\n"
                +" \"gender\": \"male\",\n"
                +" \"email\": \"%s\",\n",email);

        //Act
        usersClient.createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(String.format("%s",email)))
                .body("name",Matchers.equalTo("Tenali Ramakrishna"));

    }

    @Test
    public void createNewFemaleUSer(){
        //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body=String.format(" \"name\": \"Raziya\",\n"+
                " \"gender\": \"female\",\n"+
                " \"email\": \"%s\",\n",email);

        //Act
        usersClient.createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Raziya"));
    }


}
