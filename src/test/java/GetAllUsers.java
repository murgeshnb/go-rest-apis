
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserService;
import users.getAll.GetAllUsersResponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetAllUsers {

    //Arrange
    private UserService userService;

    @BeforeClass
    public void beforeClass(){
        userService=new UserService();
    }

    @Test
    public void getAllUSers(){
        //Act
        GetAllUsersResponse getAllUsersResponse = userService.getAllUsers();

        //Assert
        assertEquals(getAllUsersResponse.getStatusCode(),200);
        assertEquals(getAllUsersResponse.getDataList().size(),10);
        assertTrue(getAllUsersResponse.hasMaleUSer());
    }
}
