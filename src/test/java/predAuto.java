import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class predAuto {
    @Test
    void getPrice(){
        //Specify the base URI
        RestAssured.baseURI="http://192.168.29.241:5000";

        //request object
        RequestSpecification httprequest=RestAssured.given();

        //response object
        Response response= httprequest.request(Method.POST,"/predict");

        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

        //status code verification
        int statusCode=response.getStatusCode();
        System.out.println("Status code is:"+statusCode);
        Assert.assertEquals(statusCode,500);

        //status line verification.
        String statusLine=response.getStatusLine();
        System.out.println("Status Line is:"+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.0 500 INTERNAL SERVER ERROR");
    }
}
