package com.ebill.stepdef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EBillCalculatorApiStepDefs {
	String baseUrl;
	ResponseEntity<String> result;

	@Given("I Set GET electricity Bill service api endpoint")
	public void i_set_get_electricity_bill_service_api_endpoint() {
		baseUrl = "http://192.168.1.18:8080/getElectricitybill?unitOfConsumption=";
		System.out.println("Invoking getElectricitybill Api");
	}

	@When("Send a GET HTTP request")
	public void send_a_get_http_request() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		baseUrl = baseUrl+"123";
		System.out.println("Base URl is "+baseUrl);
		URI uri = new URI(baseUrl);
		result = restTemplate.getForEntity(uri, String.class);

	}

	@Then("I receive valid Response HTTP response code {int}")
	public void i_receive_valid_response_http_response_code(Integer int1) {
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		assertTrue(result.getStatusCode() == HttpStatus.OK);
		System.out.println("Successfully received the response");
		System.out.println("Response body is " + result.getBody().toString());
		// verify the responseObject
		// {"energyCharges":563.85,"fcaCharges":15.99,"dutyCharges":14.9838,"electricityBill":594.8238}
		assertEquals(true, result.getBody().contains("energyCharges"));
		System.out.println("Response body contains energyCharges");
		assertEquals(true, result.getBody().contains("fcaCharges"));
		System.out.println("Response body contains fcaCharges");
		assertEquals(true, result.getBody().contains("dutyCharges"));
		System.out.println("Response body contains dutyCharges");
		assertEquals(true, result.getBody().contains("electricityBill"));
		System.out.println("Response body contains electricityBill");
		System.out.println("getElectricitybill Api call completed");
	}

}
