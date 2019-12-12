package com.fliptweet.user;

public class Users {

	String username;

	public Users() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void createUser(String username) {
		setUsername(username);

	}

	@Override
	public String toString() {
		return "Users [username=" + username + "]";
	}

}
