package Practice;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Rest123 {

    @Test
    public void test12(){
        JSONObject request = new JSONObject();
        request.put("id", "dfZxMhYAV");
        System.out.println(request.toJSONString());
        baseURI = "https://cdn2.thedogapi.com";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("/images/dfZxMhYAV.jpg")
                .then()
                .statusCode(403).log().body();
    }

}
