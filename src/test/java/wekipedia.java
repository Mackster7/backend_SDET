import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class wekipedia {
    @Test
    void WekiTest(){
        //Base URL specification.
        RestAssured.baseURI="https://en.wikipedia.org/";

        //Request object.
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response= httpRequest.request(Method.POST,"wiki/Main_Page");
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

        //Capture Details
        String verify=response.header("x-content-type-options");
        Assert.assertEquals(verify,"nosniff");


        //status code verification
        int statusCode=response.getStatusCode();
        System.out.println("Status code is:"+statusCode);
        Assert.assertEquals(statusCode,200);

        //status line verification.
        String statusLine=response.getStatusLine();
        System.out.println("Status Line is:"+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }
}
