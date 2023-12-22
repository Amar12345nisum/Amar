package Practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Apimethodes {

    @Test
    public void Test_1(){
        String url = "https://reqres.in/api/users?page=2";
        JSONObject met = new JSONObject();
        RequestSpecification rwed = RestAssured.given();
                Response response = rwed.get(url);
                ResponseBody body = response.getBody();
                int statusCode = response.getStatusCode();
        given()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(met.toJSONString()).log().all();
        when()
                .get(url).
        then()
                .statusCode(200).log().body();
                System.out.println(statusCode);
                System.out.println("Response body is:"+body.asString());



    }

    @Test
    public void multi(){

    }
}
