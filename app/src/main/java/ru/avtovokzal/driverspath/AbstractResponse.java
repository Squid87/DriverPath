package ru.avtovokzal.driverspath;

import com.google.gson.annotations.SerializedName;


public abstract class AbstractResponse {
	@SerializedName("error")
	public Error mError;

	public static class Error {
		@SerializedName("code")
		public String code;

		@SerializedName("message")
		public String message;
	}
}
