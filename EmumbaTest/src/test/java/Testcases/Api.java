package Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class Api {
	
    //////First Get Api
	@Test(priority = 1)
	public void Test_1Get() {
		given().
		get("https://emumba-test.herokuapp.com/trend")
		.then()
		.statusCode(201)
		.time(lessThan(1000L))
		.log().all();
	}
	
    ///////Second Post Api	
	@Test(priority = 2)
	public void Test2_Post() {
		JSONObject request = new JSONObject();
		request.put("first_name", "Ali");
		request.put("last_name", "Ahmad");
		request.put("email", "ali.ahmad@gmail.com");
		request.put("password", "12345");
		request.put("confirm_password", "12345");

		given()
		.body(request.toJSONString()).
		when().
		post("https://emumba-test.herokuapp.com/user").
		then().
		statusCode(200)
		.time(lessThan(1000L))
		.log().all();
	}
	
    ///////Third Post Api	
	@Test(priority = 3)
	public void Test3_Post() {
		JSONObject request = new JSONObject();
		request.put("email", "ali.ahmad@gmail.com");
		request.put("password", "12345");
        
		ValidatableResponse response=
		given()
		.body(request.toJSONString()).
		when().
		post("https://emumba-test.herokuapp.com/user/login").
		then().
		statusCode(200)
		.time(lessThan(2000L))
		.log().all();
	}
	
}
