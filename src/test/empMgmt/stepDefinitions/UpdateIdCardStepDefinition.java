package test.empMgmt.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpdateIdCardStepDefinition {

	private static final Logger logger = Logger.getLogger(UpdateIdCardStepDefinition.class);
	
	String host = "http://localhost:8080/EmployeeManagement";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();
			
	@When("^User Click Existing Id Card by Id$")
	public void user_Click_Existing_Id_Card_by_Id() throws Throwable {
		url = host + "/updateidcard";
		logger.info("user click update id card button");
	}

	@When("^User Edit Id Card Details$")
	public void user_Edit_Id_Card_Details() throws Throwable {
		body = "{\"idCard\":{\"employee\":{\"empId\": 1}},\"columnName\":\"newOrReplace\",\"columnValue\":\"replace\"}";
		requestBody = RequestBody.create(header, body);
		logger.info("user select id card to update");
	}

	@When("^User Click Update Id Card Button$")
	public void user_Click_Update_Id_Card_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .post(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Id Card Updated Successfully$")
	public void message_Displayed_Id_Card_Updated_Successfully() throws Throwable {
		logger.info(response.body().string());
	}
}
