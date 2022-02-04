import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class JSONbody {
    @Test
    void validateJSONbody(){
        RestAssured.baseURI="http://universities.hipolabs.com";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/search?country=United+States");
        JsonPath JSONPATH=response.jsonPath();
        System.out.println((String) JSONPATH.get("x[1].name"));
        Assert.assertEquals(JSONPATH.get("x[0].name"),"Marywood University");

    }
}
