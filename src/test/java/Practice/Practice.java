package Practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
//import org.testng.reporters.XMLConstants;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.time.DurationFormatUtils.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToObject;

public class Practice {
    @Test
    public void rest() {
        Response res = RestAssured.get("https://api.genderize.io?name=luc");
        res.getStatusCode();
        res.getTime();
        res.getBody();
        res.getHeaders();
        System.out.println(res.getStatusCode());
        System.out.println(res.getTime());
        System.out.println(res.getBody().asString());
        //System.out.println(res.getHeaders());

    }

    @Test
    public void Test_2() {
        String url = "https://api.genderize.io?name=luc";
        given().get(url)
                .then()
                .statusCode(200)
                .body("gender", equalTo("male"));


        System.out.println();
    }

    @Test
    public void Test3() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Raghav");
//        map.put("job", "Teacher");
//        System.out.println(map);
        JSONObject request = new JSONObject();
        request.put("name", "Amar");
        request.put("job","Software");
        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("/users")
                .then()
                .statusCode(201).log().body();

    }

    @Test
    public void Test_4() {
        //JSONObject requ1 = new JSONObject();
        baseURI = "https://reqres.in/api";
        RequestSpecification requ1 = RestAssured.given();
        Response response = requ1.get("/users?page=2");
        ResponseBody body = response.getBody();
        int statusCode = response.getStatusCode();
        //String satus = JsonPath.read(json,"statusCode").toString();
        System.out.println(statusCode);
        System.out.println("Response body is:" + body.asString());
        //Assertions.assertEqulas("200",statusCode);


//        given()
//                .header("Content-Type","application/json")
//                .body(req_1.toJSONString()).
//        when()
//                .get("/users?page=2").
//        then()
//                .statusCode(200);
    }

    @Test
    public void Test_5() {
        given().when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", Matchers.equalTo(7)).log().body();

    }
    public void Test6(){
        String link = "https://www.sandbox.paypal.com/xoplatform/logger/api/logger?disableSetCookie=true";

    }

}