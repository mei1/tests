package test.empMgmt.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DeleteIdCardStepDefinition {

	private static final Logger logger = Logger.getLogger(DeleteIdCardStepDefinition.class);
	
	String host = "http://localhost:8080/EmployeeManagement";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();
	
	@When("^User Select Id Card by Id to Delete$")
	public void user_Select_Id_Card_by_Id_to_Delete() throws Throwable {
		url = host + "/deleteidcard";
		body = "{\"empId\": 2}";
		requestBody = RequestBody.create(header, body);
		logger.info("user select id card to delete");
	}

	@When("^User Click on Delete Id Card Button$")
	public void user_Click_on_Delete_Id_Card_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .delete(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Id Card Deleted Successfully$")
	public void message_Displayed_Id_Card_Deleted_Successfully() throws Throwable {
		logger.info(response.body().string());
	}
}
