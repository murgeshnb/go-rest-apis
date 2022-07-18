package create.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;


@Getter
public class CreateUserErrorResponse {

    @Setter
    private int statusCode;

    @JsonProperty("message")
    private Message messages;
    @JsonProperty("field")
    private Field fields;

    public void assertHasError(String field, String message) {
        assertEquals(messages.getMessage(),message);
        assertEquals(fields.getField(),field);

       /* int size1 = this.field.stream().filter(field1 -> field1.getField().equals(field)).collect(Collectors.toList()).size();
        assertEquals(size1,1);

        int size2 = this.message.stream().filter(message1 -> message1.getMessage().equals(message)).collect(Collectors.toList()).size();
        assertEquals(size2,1);*/
    }
}
