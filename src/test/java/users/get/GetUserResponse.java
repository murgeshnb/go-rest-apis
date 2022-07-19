package users.get;

import create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import static org.testng.Assert.*;

@Getter
public class GetUserResponse {

    @Setter
    private int statusCode;

    private Data data;
    private String meta;

    public void assertUSer(CreateUserRequestBody createUserRequestBody) {
        assertEquals(data.email,createUserRequestBody.getEmail());
        assertEquals(data.gender,createUserRequestBody.getGender());
        assertEquals(data.name,createUserRequestBody.getName());
        assertEquals(data.status,createUserRequestBody.getStatus());
    }

    @Getter
    public static class Data{
        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }
}
