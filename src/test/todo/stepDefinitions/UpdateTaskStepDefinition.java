package test.todo.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UpdateTaskStepDefinition {

	private static final Logger logger = Logger.getLogger(UpdateTaskStepDefinition.class);
	
	String host = "http://localhost:8080/To-do";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();
	
	@When("^User Click Existing Task by Task Id$")
	public void user_Click_Existing_Task_by_Task_Id() throws Throwable {
		url = host + "/updatetask";
		logger.info("user click new task button");
	}

	@When("^User Edits Task Details$")
	public void user_Edits_Task_Details() throws Throwable {
		body = "{\"task\":{\"taskGroup\":{\"taskGroupId\": 1}},\"taskTitle\":\"dinner meeting\",\"taskContent\":\"dinner meeting at city hall\"}";
		requestBody = RequestBody.create(header, body);
		logger.info("user select task to update");
	}
	
	@When("^User Click Update Button$")
	public void user_Click_Update_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .post(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Task Updated Successfully$")
	public void message_Displayed_Task_Updated_Successfully() throws Throwable {
		logger.info(response.body().string());
	}
	
}
