package com.becker.bank.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtils {

	private static ObjectMapper mapper;
	
	public static <T> T convert(Object from, Class<T> to) {
        return mapper.convertValue(from, to);
    }
}
