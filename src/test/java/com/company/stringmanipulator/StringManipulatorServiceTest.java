/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.company.stringmanipulator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.company.stringmanipulator.service.StringManipulatorService;

/**
 * @author Dinesh L
 *
 */

public class StringManipulatorServiceTest {

	@Test
	public void testfilterLongest() throws Exception {
		final StringManipulatorService classUnderTest = new StringManipulatorService();
		final List<String> request = new ArrayList<String>();
		request.add("Wind");
		request.add("Mill");
		request.add("WindMill Solutions");

		assertEquals("WindMill Solutions", classUnderTest.filter("LONGEST", request).getData().get(0));

	}
	
	@Test
	public void testfilterLongest_EmptyList() throws Exception {
		final StringManipulatorService classUnderTest = new StringManipulatorService();
		final List<String> request = new ArrayList<String>();
		
		assertEquals(0, classUnderTest.filter("LONGEST", request).getData().size());

	}
	
	@Test
	public void testfilterDelete() throws Exception {
		final StringManipulatorService classUnderTest = new StringManipulatorService();
		final List<String> request = new ArrayList<String>();
		request.add("Wind");
		request.add("Mill");
		request.add("WindMill Solutions");

		assertEquals("WindMill Solutions", classUnderTest.filter("DELETE", request).getData().get(0));

	}
	
	@Test
	public void testfilterDelete_EmptyList() throws Exception {
		final StringManipulatorService classUnderTest = new StringManipulatorService();
		final List<String> request = new ArrayList<String>();
		
		assertEquals(0, classUnderTest.filter("DELETE", request).getData().size());

	}


}
