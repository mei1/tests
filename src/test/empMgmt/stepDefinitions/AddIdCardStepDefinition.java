package test.empMgmt.stepDefinitions;

import org.apache.log4j.Logger;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddIdCardStepDefinition {
	
	public static final Logger logger = Logger.getLogger(AddIdCardStepDefinition.class);
	
	String host = "http://localhost:8080/EmployeeManagement";
	String url = null;
	MediaType header = MediaType.parse("application/json; charset=utf-8");
	String body = null;

	RequestBody requestBody = null;
	Request request = null;
	Response response = null;
	OkHttpClient client = new OkHttpClient();
	
	@When("^User Select Employee by Id to add Id Card Data$")
	public void user_Select_Employee_by_Id_to_add_Id_Card_Data() throws Throwable {
		url = host + "/insertidcarddata";
		logger.info("user select emp by id to add id card data");
	}

	@When("^User Enters Id Card Details$")
	public void user_Enters_Id_Card_Details() throws Throwable {
		body =  "{\"idCard\":{\"employee\":{\"empId\":\"8\"},\"employeePhoto\":\"pretty and cute photo\",\"companyName\":\"google\",\"employeeName\":\"Tan Mei\",\"newOrReplace\":\"new\",\"issueDate\":\"19022017\"}}";
		requestBody = RequestBody.create(header, body);
		logger.info("user add id card data to selected emp");
	}
	
	@When("^User Click Save Id Card Button$")
	public void user_Click_Save_Id_Card_Button() throws Throwable {
		request = new Request.Builder()
			      .url(url)
			      .post(requestBody)
			      .build();
		response = client.newCall(request).execute();
	}

	@Then("^Message Displayed Id Card Added Successfully$")
	public void message_Displayed_Id_Card_Added_Successfully() throws Throwable {
		logger.info(response.body().string());
	}

}
