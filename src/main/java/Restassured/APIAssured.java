package Restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIAssured {
	
	public static String GetRestassured() {
		RestAssured.baseURI="https://parabank.parasoft.com";
		return RestAssured.baseURI;
	}
	public static RequestSpecification requestspecificationparabank() {
		RequestSpecification req= new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri(APIAssured.GetRestassured()).addHeader("Content-Type","application/json").
				build();
		return req;
		
	}
	public static ResponseSpecification responsespecificationcall() {
		ResponseSpecification res= new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		return res;
	}
	public static String Sendingcall(int code) {
		String send=RestAssured.given().log().all().spec(APIAssured.requestspecificationparabank())
				.spec(APIAssured.requestspecificationparabank())
				.get("/parabank/services_proxy/bank/customers/14765/accounts").then().log().all().
				spec(APIAssured.responsespecificationcall()).statusCode(code).extract().response().asString();
		
			return send;
				
	}
	public static String reponsecode(int code, String typeres) {
		JsonPath js=new JsonPath(APIAssured.Sendingcall(code));
		typeres=js.getString("message");
		System.out.print(typeres);
		return typeres;
	}
}
