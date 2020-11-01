package com.company.stringmanipulator.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.company.stringmanipulator.pojo.Response;
import com.company.stringmanipulator.utils.ApplicationConstant;

@Service
public class StringManipulatorService {

	public Response filter(final String filterType, final List<String> request) {
		if (filterType.equalsIgnoreCase(ApplicationConstant.LONGEST) && request != null) {
			final Optional<String> optionalString = request.parallelStream()
					.max(Comparator.comparingInt(String::length));
			return new Response(optionalString.isPresent() ? Arrays.asList(optionalString.get()) : null);
		} else if (filterType.equalsIgnoreCase(ApplicationConstant.DELETE) && request != null) {
			final Stream<String> all = request.parallelStream();
			final List<String> longNames = all.filter(str -> str.length() > 10).collect(Collectors.toList());
			return new Response(longNames.isEmpty() ? null : longNames);
		} else
			return new Response(null);
	}
}
