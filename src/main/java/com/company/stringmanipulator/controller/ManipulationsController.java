package com.company.stringmanipulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.stringmanipulator.pojo.Response;
import com.company.stringmanipulator.service.StringManipulatorService;
import com.company.stringmanipulator.utils.ApplicationConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(ApplicationConstant.VERSION_ENDPOINT)
@Api(value = "String filter endpoints for searching LONGEST string.")

public class ManipulationsController {

	@Autowired
	private StringManipulatorService stringManipulatorService;

	@ApiOperation(value = "Returns longest string.", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = ApplicationConstant.STRINGS_LONGEST_ENDPOINT, method = RequestMethod.POST, produces = ApplicationConstant.APPLICATION_CONTENT, consumes = ApplicationConstant.APPLICATION_CONTENT)
	public ResponseEntity<Response> longest(@RequestBody final List<String> request) {
		return ResponseEntity.ok(stringManipulatorService.filter(ApplicationConstant.LONGEST, request));
	}

	@ApiOperation(value = "Returns strings with length upto 10 character.", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = ApplicationConstant.STRINGS_ENDPOINT, method = RequestMethod.DELETE)
	public ResponseEntity<Response> delete(@RequestBody final List<String> request) {
		return ResponseEntity.ok(stringManipulatorService.filter(ApplicationConstant.DELETE, request));
		//return ResponseEntity.ok(new String());
	}

	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

}