package test.empMgmt.stepDefinitions;

import java.util.Calendar;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddNewEmpStepDefinition {

	private static final Logger logger = Logger.getLogger(AddNewEmpStepDefinition.class);

	String host = "http://localhost:8080/EmployeeManagement";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		logger.info("user is on home page");
	}

	@When("^User Click New Employee Button$")
	public void user_Click_New_Employee_Button() throws Throwable {
		url = host + "/insertempdata";
		logger.info("user click new employee button");
	}

	@When("^User Enters New Employee Details$")
	public void user_Enters_New_Employee_Details() throws Throwable {
		String tmpTitleStr = "Test Task Title " + Calendar.getInstance().getTime().toGMTString();
		String tmpBodyStr = "Test Task Body " + Calendar.getInstance().getTime().toGMTString();
		
		body = "{\"emp\":{\"empId\":\"3\", \"firstName\":\"Tan\", \"lastName\":\"mei\", \"dob\":\"24051989\", \"address\":\"Malaysia" + tmpTitleStr + "\", \"age\":\"20\", \"joinDate\":\"20022017\", \"salary\":\"2000\"}}";
		requestBody = RequestBody.create(header, body);
	}

	@When("^User Click Save Button$")
	public void user_Click_Save_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .post(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Employee Added Successfully$")
	public void message_Displayed_Employee_Added_Successfully() throws Throwable {
		logger.info(response.body().string());
	}

}
