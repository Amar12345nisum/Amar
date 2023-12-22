package Practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Uploadimage {


    @Test
    public void uploadtest(){
        File uploadfile =  new File("E:\\download.jpg");

        RestAssured .baseURI = "https://cdn2.thedogapi.com";
        Response response = given()
                .multiPart(uploadfile)
                .when().post("/images/dfZxMhYAV.jpg");
        response.then().log().body();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());


    }
}
