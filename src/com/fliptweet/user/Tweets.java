package com.fliptweet.user;

import java.util.List;

public class Tweets {
	String tweet;
	int tweetId;
	String userName;
	List<String> restrict;

	@Override
	public String toString() {
		return "Tweets [tweet=" + tweet + ", tweetId=" + tweetId + "]";
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void getTweetsByUsername(String username) {
		if (this.userName == username) {
			System.out.println(this.tweet);
		}
	}

	public List<String> getRestrict() {
		return restrict;
	}

	public void setRestrict(List<String> restrict) {
		this.restrict = restrict;
	}

}
