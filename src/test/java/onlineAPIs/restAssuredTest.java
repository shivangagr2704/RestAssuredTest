package onlineAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class restAssuredTest {

    @Test
    public void createEmployee(){
        Response response = RestAssured.given().log().uri()
                .baseUri("https://dummy.restapiexample.com/api/v1/create")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"test 2\",\n" +
                        "    \"salary\": \"1234\",\n" +
                        "    \"age\": \"23\"\n" +
                        "}")
                .post();
        response.body().prettyPrint();
        JsonPath jsonPathObj = response.jsonPath();
        String status = jsonPathObj.get("status");
        System.out.println(status);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void verifyResponse(){
        Map<String,String> headers = new LinkedHashMap<>();
        headers.put("x-client-id","20268c31b12709e2d5cfa42006202");
        headers.put("x-client-secret","21aaef43c1bfe5ee418940ee3c74de14335c876");

        Response response = RestAssured.given()
                .baseUri("https://sandbox.cashfree.com/orders")
                .headers(headers)
                .contentType("application/json")
                .body("{\n" +
                        "    \"order_id\": \"OrderId\",\n" +
                        "    \"order_currency\": \"INR\",\n" +
                        "    \"order_amount\": 10.00,\n" +
                        "    \"customer_details\": {\n" +
                        "        \"customer_email\": \"EmailId\",\n" +
                        "        \"customer_phone\": \"PhNo\",\n" +
                        "        \"customer_name\": \"Name\"\n" +
                        "    }")
                .post()
                .then().log().all().extract().response();
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        JsonPath jsonPathObj = response.jsonPath();
        List<Map> employees = jsonPathObj.get("customer_age.emails.findAll{customer_age -> emails>=25}");


    }

    @Test
    public void getAPI1(){

        RestAssured.given()
                .baseUri("https://dummy.restapiexample.com/api/v1/employees");
    }
}
