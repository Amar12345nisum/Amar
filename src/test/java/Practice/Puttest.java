package Practice;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Puttest {
    @Test
    public void Test_() {

        JSONObject req = new JSONObject();
        req.put("name", "Raghav");
        req.put("job", "Teacher");
        System.out.println(req.toJSONString());
        baseURI = "https://reqres.in/api";
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString()).
                when()
                .put("/users/2")
                .then()
                .statusCode(200);
    }
}
//class A {
//
//    private int a;
//    private float b;
//
//    A() { System.out.println("Calling The Constructor"); }
//
//    public A setint(int a)
//    {
//        this.a = a;
//        return this;
//    }
//
//    public A setfloat(float b)
//    {
//        this.b = b;
//        return this;
//    }
//
//    void display()
//    {
//        System.out.println("Display=" + a + " " + b);
//    }
//}

// Driver code
//public class Example {
//    public static void main(String[] args)
//    {
//        // This is the "method chaining".
//        new A().setint(10).setfloat(20).display();
//    }


