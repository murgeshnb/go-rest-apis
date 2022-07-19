package users;

import create.CreateUserRequestBody;
import create.response.CreateUserErrorResponse;
import create.response.CreateUserResponse;
import create.response.UpdatedUserResponse;
import io.restassured.response.Response;
import users.get.GetUserErrorResponse;
import users.get.GetUserResponse;
import users.getAll.GetAllUsersResponse;

public class UserService {

    public GetUserResponse getUserOnId(int id){
        Response response = new UsersClient().get(id);
        int statusCode = response.statusCode();

        GetUserResponse getUserResponse = response.as(GetUserResponse.class);

        getUserResponse.setStatusCode(statusCode);

        return getUserResponse;
    }

    public GetAllUsersResponse getAllUsers() {

        Response response = new UsersClient().getAll();

        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(response.statusCode());

        return getAllUsersResponse;
    }

    public CreateUserErrorResponse[] createUserExpectingError(CreateUserRequestBody body) {

        Response negativeResponse = new UsersClient().create(body);
        CreateUserErrorResponse[] createUserErrorResponse = negativeResponse.as(CreateUserErrorResponse[].class);

        for (CreateUserErrorResponse  resp:createUserErrorResponse) {
            resp.setStatusCode(negativeResponse.statusCode());
        }
        return createUserErrorResponse;
    }

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = new UsersClient().create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());

        return createUserResponse;
    }

    public GetUserErrorResponse getUSerErrorResponse(int id){
        Response response = new UsersClient().get(id);
        int statusCode = response.statusCode();

        GetUserErrorResponse getUserErrorResponse = response.as(GetUserErrorResponse.class);

        getUserErrorResponse.setStatusCode(statusCode);

        return getUserErrorResponse;
    }

    public int deleteUser(int id){
        Response response = new UsersClient().delete(id);
       return response.statusCode();
    }

    public GetUserErrorResponse getUserExpectingError(int id){
        Response response = new UsersClient().get(id);
        int statusCode = response.statusCode();

        GetUserErrorResponse getUserErrorResponse = response.as(GetUserErrorResponse.class);
        getUserErrorResponse.setStatusCode(statusCode);
        return getUserErrorResponse;

    }

    public UpdatedUserResponse getUpdatedUserDetails(CreateUserRequestBody createUserRequestBody,int id){
        Response response = new UsersClient().updateUser(createUserRequestBody, id);
        int statusCode = response.statusCode();

        UpdatedUserResponse updatedUserResponse = response.as(UpdatedUserResponse.class);
        updatedUserResponse.setStatusCode(statusCode);

        return updatedUserResponse;
    }


}
