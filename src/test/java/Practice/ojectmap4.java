package Practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ojectmap4 {

    @Test
    public void obj() throws JsonProcessingException {
        JSONObject request = new JSONObject();
        request.put("name", "Amar");
        request.put("job","Software");
        ObjectMapper ob = new ObjectMapper();
        String db = ob.writeValueAsString(request);
        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(db).
                when()
                .post("/users")
                .then()
                .statusCode(201).log().body();
    }

}


