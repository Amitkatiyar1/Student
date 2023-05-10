package com.example.Curd.Service;

public class LoginResponse {

	private boolean status;

	@Override
	public String toString() {
		return "LoginResponse [  status=" + status + "]";
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LoginResponse(boolean status) {
		super();

		this.status = status;
	}
}
