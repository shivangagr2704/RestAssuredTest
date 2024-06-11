package restUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String,String> headers){
        return RestAssured.given()
                .baseUri(endpoint)
                .headers(headers)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint : " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method : " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers : ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request Body : ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response Status : " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers : ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response Body : ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    private static void printLogsInReport(RequestSpecification requestSpecification, Response response){
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
    }

    public static Response performPost(String endpoint, String requestPayload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endpoint,requestPayload,headers);
        Response response = requestSpecification.post();
        printLogsInReport(requestSpecification, response);
        return response;
    }

    public static Response performPost(String endpoint, Map<String,Object> requestPayload, Map<String,String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endpoint,requestPayload,headers);
        Response response = requestSpecification.post();
        printLogsInReport(requestSpecification, response);
        return response;
    }
}
