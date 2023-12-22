package Practice;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Multipleobject1 {

    String em = "https://dummy.restapiexample.com/api/v1/employees";
@Test
    public void tert()
{
    //String em = "https://dummy.restapiexample.com/api/v1/employees";
        HashMap ko = new HashMap();
        ko.put("name","Amar");
        ko.put("job","Teacher");
        HashMap ro = new HashMap();
        ro.put("name","Nisum");
        ro.put("job","SE");
        List<HashMap<String,String>> k = new ArrayList<>();
        k.add(ko);
        k.add(ro);
        given()
                .contentType(ContentType.JSON)
                .body(k)
                .when()
                .post(em)
                .then()
                .assertThat()
                .log().body();

    }
}
