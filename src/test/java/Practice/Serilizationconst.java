package Practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.Products;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Serilizationconst {
    @Test
    public void serial(){
        Products pro = new Products(1,"Text",3,5,6);

        given().baseUri("https://dummyjson.com/products")
                .body(pro)
                .when()
                .post("/add").then().log().body();
    }
    @Test
    public void testobj() throws JsonProcessingException {
        ObjectMapper ob= new ObjectMapper();
        ObjectNode on= ob.createObjectNode();
        on.put("id",35);
        on.put("LG","Old model tv sample");
        on.put("price",13.50);
        on.put("discount", 12);
        on.put("rating",37);


        String sob=ob.writeValueAsString(on);
        System.out.println(sob);

        given().body(sob).when().post("/add").then().log().body();
    }
}
