package Practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.Mock;
import org.example.Product2;
import org.junit.Test;

import static io.restassured.RestAssured.given;
//import static org.apache.commons.codec.digest.UnixCrypt.body;

public class Atesi {

    @Test
    public void obja()throws JsonProcessingException {
        ObjectMapper ab= new ObjectMapper();
        ArrayNode al = ab.createArrayNode();
        //ObjectNode on =
        ObjectNode on = ab.createObjectNode();
        on.put("id",35);
        on.put("LG","Old model tv sample");
        on.put("price",13.50);
        on.put("discount", 12);
        on.put("rating",37);

       ObjectNode on1= ab.createObjectNode();
        on1.put("id",38);
        on1.put("Samsung","New model tv");
        on1.put("price",25.50);
        on1.put("discount", 10);
        on1.put("rating",40);
        al.add(on);
        al.add(on1);
        String sob = ab.writeValueAsString(al);
        System.out.println(sob);

        given().body(sob).when().post("/add").then().log().body();
    }

    @Test
    public void adcb(){
        Mock  mo= new Mock("foot1","foot2");
         given().baseUri("https://20f50f2a-1f7e-4da3-ba7c-e1cff4395ec9.mock.pstmn.io/simplepost")
                .body(mo)
                .when()
                .post().then().log().all();


    }
}
