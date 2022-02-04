import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class printHeaders {
    @Test
    public void getHeaders(){
        //specifying base URI
        RestAssured.baseURI="https://www.google.com";
        //Request object
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"/search?q=car+wash+nearme&oq=car+wash+nearme&aqs=chrome..69i57j0i10i433i457j0i402l2j0i10l6.5135j0j7&sourceid=chrome&ie=UTF-8");

        //captures all the headers
        Headers allheaders=response.headers();

        for (Header header:allheaders) {
            System.out.println("Key:" + header.getName() + "    Value:" + header.getValue());
        }

        String responseBody=response.getBody().asString();
        Assert.assertEquals(responseBody.contains(".bRsWnc"),true);
    }
}
