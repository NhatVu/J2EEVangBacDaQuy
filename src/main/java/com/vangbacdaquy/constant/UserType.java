package com.vangbacdaquy.constant;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
	
	ADMIN(1),
	EDITOR(2),
	DEFAULT(3);

	private Integer value;

	private static Map<Integer, UserType> values = null;

	public Integer getValue() {
		return value;
	}

	UserType(Integer value) {
		this.value = value;
	}

	public static UserType parseValue(Integer value) {
		if (values == null) {
			values = new HashMap<Integer, UserType>(UserType.values().length);
			for (UserType e : UserType.values())
				values.put(e.getValue(), e);
		}
		return values.get(value);
	}
}