package com.company.stringmanipulator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.company.stringmanipulator.pojo.Response;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ManipulationsControllerITests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@SuppressWarnings("rawtypes")
	@Test
	public void testStringsLongestFirstValue_EndPoint_Post() throws Exception {
		final List<String> request = new ArrayList<String>();
		request.add("Wind");
		request.add("Mill");
		request.add("WindMill Solutions");

		ResponseEntity<Response> response = restTemplate.postForEntity(
				new URL("http://localhost:" + port + "/stringmanipulator/api/1.0/manipulations/strings/longest")
						.toString(),
				request, Response.class);
		assertEquals("WindMill Solutions", ((List) response.getBody().getData()).get(0));
		assertEquals("MATCH FOUND", response.getBody().getMessage());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testStringsLongest_EmptyListRequest_EndPoint_Post() throws Exception {

		ResponseEntity<Response> response = restTemplate.postForEntity(
				new URL("http://localhost:" + port + "/stringmanipulator/api/1.0/manipulations/strings/longest")
						.toString(),
				new ArrayList<String>(), Response.class);
		assertEquals(0, ((List) response.getBody().getData()).size());
		assertEquals("NO MATCH FOUND", response.getBody().getMessage());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testStringsLengthSize_EndPoint_Delete() throws Exception {
		final List<String> request = new ArrayList<String>();
		request.add("Wind");
		request.add("Mills");
		request.add("WindMill Solutions");

		ResponseEntity<Response> response = restTemplate.exchange(
				"http://localhost:" + port + "/stringmanipulator/api/1.0/manipulations/strings", HttpMethod.DELETE,
				new HttpEntity<List<String>>(request), Response.class, "");
		assertEquals("WindMill Solutions", ((List) response.getBody().getData()).get(0));
		assertEquals("MATCH FOUND", response.getBody().getMessage());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testStringsLengthSize_EmptyListRequest_EndPoint_Delete() throws Exception {

		final List<String> request = new ArrayList<String>();

		ResponseEntity<Response> response = restTemplate.exchange(
				"http://localhost:" + port + "/stringmanipulator/api/1.0/manipulations/strings", HttpMethod.DELETE,
				new HttpEntity<List<String>>(request), Response.class, "");
		assertEquals(0, ((List) response.getBody().getData()).size());
		assertEquals("NO MATCH FOUND", response.getBody().getMessage());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testStringsLengthSize_InvalidRequest_EndPoint_Delete() throws Exception {

		final List<String> request = new ArrayList<String>();
		request.add("Wind");
		request.add("Mills");

		ResponseEntity<Response> response = restTemplate.exchange(
				"http://localhost:" + port + "/stringmanipulator/api/1.0/manipulations/strings", HttpMethod.DELETE,
				new HttpEntity<List<String>>(request), Response.class, "");
		assertEquals(0, ((List) response.getBody().getData()).size());
		assertEquals("NO MATCH FOUND", response.getBody().getMessage());
	}

}