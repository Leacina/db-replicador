package br.com.replicator.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum QueryTypes {
	INSERT("insert", "Insert"),
	UPDATE("update", "Update"),
	DELETE("delete", "Delete"),
	SELECT("select", "Select");

	private final String code;
	private final String description;
	private static final Map<String, String> mMap = Collections.unmodifiableMap(initializeMapping());

	private QueryTypes(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static String getDescriptionByCode(String code) {
		if (mMap == null) {
			initializeMapping();
		}

		if (mMap.containsKey(code)) {
			return mMap.get(code);
		}
		return null;
	}

	public static Map<String, String> getDatabases() {
		if (mMap == null) {
			initializeMapping();
		}

		return mMap;
	}

	private static Map<String, String> initializeMapping() {
		Map<String, String> mMap = new HashMap<String, String>();
		for (QueryTypes s : QueryTypes.values()) {
			mMap.put(s.code, s.description);
		}
		return mMap;
	}
}
