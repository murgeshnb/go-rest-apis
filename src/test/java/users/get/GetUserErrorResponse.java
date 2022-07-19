package users.get;

import lombok.Getter;
import lombok.Setter;

import static org.testng.Assert.assertEquals;

@Getter
public class GetUserErrorResponse {

    @Setter
    private int statusCode;

    private Data data;
    private String meta;

    public void asserError(int expectedStatusCode,String expectedMessage) {
        assertEquals(data.message,expectedMessage);
        assertEquals(statusCode,expectedStatusCode);
    }

    @Getter
    public static class Data{
        private String message;
    }
}
