package test.todo.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DeleteTaskStepDefinition {
	
	private static final Logger logger = Logger.getLogger(DeleteTaskStepDefinition.class);
	
	String host = "http://localhost:8080/To-do";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();
	
	@When("^User Select Task by Task Id to Delete$")
	public void user_Select_Task_by_Task_Id_to_Delete() throws Throwable {
		url = host + "/deletetask";
		body = "{\"taskGroup\":{\"taskGroupId\":\"1\"}}";
		requestBody = RequestBody.create(header, body);
		logger.info("user select task to delete");
	}

	@When("^User Click on Delete Button$")
	public void user_Click_on_Delete_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .delete(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Task Deleted Successfully$")
	public void message_Displayed_Task_Deleted_Successfully() throws Throwable {
		logger.info(response.body().string());
	}
}
