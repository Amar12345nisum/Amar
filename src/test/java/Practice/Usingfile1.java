package Practice;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Usingfile1 {
    //
    @Test
    public void file1(){
        baseURI = "https://dummyjson.com/products/add";
        File file = new File("E:\\Intelj\\RestAssuresteps\\src\\main\\resources\\Nestedarry.json");
        Response res = given().body(file).when().post();
        res.then().log().body();
        int data = res.jsonPath().get("id");
        System.out.println(data);
        int espd =101;
        Assert.assertEquals(espd,data);


    }
    @Test
    public void qp(){
        baseURI="https://postman-echo.com/get";
        given().queryParam("foo1","bar1")
                .queryParam("foo2","bar2")
                .when()
                .get()
                .then()
                .log()
                .body();
    }
    @Test
    public void multipa(){
        baseURI="https://postman-echo.com";
        given().multiPart("foo1","bar1")
                .multiPart("foo2","bar2")
                .multiPart("foo3","bar3")
                .when()
                .post("/post")
                .then()
                .log()
                .all();

    }
    @Test
    public void multiuplod(){
        baseURI="https://postman-echo.com";
        File upl = new File("E:\\Intelj\\RestAssuresteps\\src\\main\\resources\\te1.txt");
        given().multiPart(upl)
                .when()
                .post("/post")
                .then()
                .log()
                .all();

    }
}

