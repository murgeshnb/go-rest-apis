package create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {                //Achieved immutability of object with custom builder. without providing setters.
    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUserRequestBody(Builder builder){
        this.name=builder.name;
        this.email=builder.email;
        this.gender=builder.gender;
        this.status=builder.status;
    }

    // step 1 custome builder pattern which builds CURB object
    public static class Builder{
        private String name;
        private String gender;
        private String email;
        private String status;

        //default const to initiate
        public Builder(){
            this.name="Tenali";
            this.gender="male";
            this.email=String.format("%s@gmail.com", UUID.randomUUID());;
            this.status="active";
        }

        //step 3 gender init
        public Builder gender(String gender){
            this.gender=gender;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder status(String status){
            this.status=status;
            return this;
        }

        public Builder name(String name){
            this.name=name;
            return this;
        }

        //step4 method which returns new instance of CURB
        public CreateUserRequestBody build(){
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);

            return createUserRequestBody;
        }
    }

}
