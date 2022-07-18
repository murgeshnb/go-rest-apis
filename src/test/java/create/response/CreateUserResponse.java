package create.response;

import create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Getter
public class CreateUserResponse {

    @Setter
    private int statusCode;

    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public void assertUser(CreateUserRequestBody createUserRequestBody) {
        assertEquals(this.getStatusCode(),201);
        assertNotNull(this.getId());
        assertEquals(this.getEmail(),createUserRequestBody.getEmail());
        assertEquals(this.getName(),createUserRequestBody.getName());
        assertEquals(this.getGender(),createUserRequestBody.getGender());
        assertEquals(this.getStatus(),createUserRequestBody.getStatus());
    }
}
