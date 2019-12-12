package com.fliptweet.user;

import java.util.List;

public class Followers {
	Users user;
	List<Users> followers;

	public Followers(Users user, List<Users> followers) {
		this.user = user;
		this.followers = followers;
	}

	public Followers addFollowers(Users user, List<Users> followers) {
		return new Followers(user, followers);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Users> followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return "Followers [user=" + user + ", followers=" + followers.toString() + "]";
	}

}
