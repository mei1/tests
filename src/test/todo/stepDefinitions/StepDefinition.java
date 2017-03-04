package test.todo.stepDefinitions;

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

public class StepDefinition {
	
	private static final Logger logger = Logger.getLogger(StepDefinition.class);
	
	//similar format to RESTclient with http, header, method, body
	String host = "http://localhost:8080/To-do";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		url = host + "/inserttaskdata";
		logger.info("user is on home page");
	}

	@When("^User Click New Task Button$")
	public void user_Click_New_Task_Button() throws Throwable {
		logger.info("user click new task button");
	}

	@When("^User Enters New Task Details$")
	public void user_Enters_New_Task_Details() throws Throwable {
		String tmpTitleStr = "Test Task Title " + Calendar.getInstance().getTime().toGMTString();
		String tmpBodyStr = "Test Task Body " + Calendar.getInstance().getTime().toGMTString();

		
		body = "{\"taskGroup\":{\"taskGroupId\":\"1\"},\"taskTitle\":\"" + tmpTitleStr + "\",\"taskContent\":\"" + tmpBodyStr + "\",\"taskDate\":\"2017-02-27\"}";
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

	@Then("^Message Displayed Task Added Successfully$")
	public void message_Displayed_Task_Added_Successfully() throws Throwable {
		logger.info(response.body().string());
	}
}
