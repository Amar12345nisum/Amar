package Practice;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Nestedobjects2 {

    @Test
    public void using()
    {
        /*"products": [
        {
            "id": 1,
            "title": "iPhone 9",
            "description": "An apple mobile which is nothing like apple",
            "price": 549,
            "discountPercentage": 12.96,
            "rating": 4.69,
            "stock": 94,
            "brand": "Apple",
            "category": "smartphones",
            "thumbnail": "
https://i.dummyjson.com/data/products/1/thumbnail.jpg"
,
            "images": [
                "
https://i.dummyjson.com/data/products/1/1.jpg"
,
                "
https://i.dummyjson.com/data/products/1/2.jpg"
,
                "
https://i.dummyjson.com/data/products/1/3.jpg"
,
                "
https://i.dummyjson.com/data/products/1/4.jpg"
,
                "
https://i.dummyjson.com/data/products/1/thumbnail.jpg"
            ]
        },
         */
        HashMap<String, Object> prod = new HashMap<String, Object>();
        HashMap<Object,Object> all =  new HashMap<Object,Object>();
        HashMap<String, String> kp = new HashMap<String, String>();
        kp.put("id", "1");
        kp.put("title", "iPhone 9");
        kp.put("description", "An apple mobile which is nothing like apple");
        kp.put("price", "549");
        kp.put("discountPercentage", "12.96");
        kp.put("rating", "4.69");
        kp.put("stock", "94");
        kp.put("brand", "Apple");
        kp.put("category", "smartphones");
        kp.put("thumbnail", "https://i.dummyjson.com/data/products/1/thumbnail.jpg");
        HashMap<String, Object> img = new HashMap<String, Object>();
        HashSet<String> link = new HashSet<String>();
        link.add("https://i.dummyjson.com/data/products/1/1.jpg");
        link.add("https://i.dummyjson.com/data/products/1/2.jpg");
        link.add("https://i.dummyjson.com/data/products/1/3.jpg");
        link.add("https://i.dummyjson.com/data/products/1/4.jpg");
        link.add("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
        img.put("images",link);
         prod.put("products",kp);
         all.put(prod,img);
         baseURI = "https://dummyjson.com/products/add";
        Response response = given().body(all).when().get();
        response.then().statusCode(404).body(matchesJsonSchemaInClasspath("E:\\Intelj\\RestAssuresteps\\src\\main\\resources\\echo.json")).log().all();
        int id2 = 1;
        int id3 = response.jsonPath().get("id");
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        Assert.assertEquals(id2,id3);

    }
}

