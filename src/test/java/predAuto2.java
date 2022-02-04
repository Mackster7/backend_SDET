import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class predAuto2 {

    //SENDING A POST REQUEST WITH A BODY.
    @Test
    void getPrice(){
        //Specify the base URI
        RestAssured.baseURI="http://192.168.29.241:5000/predict";

        //request object
        RequestSpecification httprequest=RestAssured.given();

        //request params
        JSONObject requestParams=new JSONObject();
        requestParams.put("name","Hyundai Santro Xing");
        requestParams.put("company","Hyundai");
        requestParams.put("year","2007");
        requestParams.put("kms_driven","78000");
        requestParams.put("fuel_type","Petrol");
        httprequest.header("Content-Type","application/json");

        httprequest.body(requestParams.toJSONString());



        //response object
        Response response= httprequest.request(Method.POST,"");

        //print response in console window.
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:"+responseBody);


        //status code verification
        int statusCode=response.getStatusCode();
        System.out.println("Status code is:"+statusCode);
        Assert.assertEquals(statusCode,200);

        //status line verification.
        String statusLine=response.getStatusLine();
        System.out.println("Status Line is:"+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.0 200 OK");
    }
}
