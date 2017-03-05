package test.empMgmt.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpdateEmpStepDefinition {
	
	private static final Logger logger = Logger.getLogger(UpdateEmpStepDefinition.class);
	
	String host = "http://localhost:8080/EmployeeManagement";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();

	@When("^User Click Existing Employee by Id$")
	public void user_Click_Existing_Employee_by_Id() throws Throwable {
		url = host + "/updateemp";
		logger.info("user click update emp button");
	}

	@When("^User Edit Employee Details$")
	public void user_Edit_Employee_Details() throws Throwable {
		body = "{\"emp\":{\"empId\": 2},\"columnName\":\"address\",\"columnValue\":\"Chennai\"}";
		requestBody = RequestBody.create(header, body);
		logger.info("user select emp to update");
	}

	@When("^User Click Update Button$")
	public void user_Click_Update_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .post(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Employee Updated Successfully$")
	public void message_Displayed_Employee_Updated_Successfully() throws Throwable {
		logger.info(response.body().string());
	}
}
