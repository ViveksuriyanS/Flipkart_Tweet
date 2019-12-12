package com.fliptweet.user;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlipTweet {

	public static List<Users> userList = new LinkedList<Users>();
	public static List<Followers> followersList = new LinkedList<Followers>();
	public static List<Tweets> tweetsList = new LinkedList<Tweets>();
	static int tweetId = 0;

	public static void main(String[] args) {
		// Adding users
		Users user1 = addUsers("Gopal");
		Users user2 = addUsers("Madhav");
		Users user3 = addUsers("Lucky");
		Users user4 = addUsers("Laxman");
		Users user5 = addUsers("Vivek");
		Users user6 = addUsers("Shitij");
		Users user7 = addUsers("Suriyan");
		System.out.println(userList);

		// Adding followers to the user
		addFollowers(new Followers(user1, Arrays.asList(user5, user6, user7)));
		addFollowers(new Followers(user3, Arrays.asList(user2, user1, user4)));
		addFollowers(new Followers(user6, Arrays.asList(user2, user1)));
//		System.out.println(followersList);

		// Posting Tweets
		postTweet("A1 by Vivek", "Vivek");
		postTweet("A2 by Shitij", "Shitij");
		postTweet("A3 by Suriyan", "Suriyan");
		postTweet("Bonjour by Madhav", "Madhav");
//		System.out.println(tweetsList);

		// Getting tweets by user
		getTweetsByUser("Gopal");
		getTweetsByUser("Suriyan");

		// Posting tweet
		postTweet("Bonjour by Lucky", "Lucky");
		deleteTweetByID(5, "Lucky");
		// Get user feed by user
		getUserFeedByUser("Suriyan");
		getUserFeedByUser("Laxman");

		getUserFeedByUser("Lucky");

		// 9 - Hide Tweet for user By tweet it
//		hideTweetForUserByTweetId("Madhav", 1);

		// 10 -
		getUserFeedByUser("Madhav");
		getUserFeedByUser("Suriyan");
		getUserFeedByUser("Gopal");

		// 11- Delete Tweet
//		deleteTweetByID(2, "Gopal");

		// 12-
		getUserFeedByUser("Laxman");

		// 13 -
		getUserFeedByUser("Madhav");

		// 14
		getUserFeedByUser("Gopal");

	}

	private static void hideTweetForUserByTweetId(String username, int i) {
		for (Tweets tweet : tweetsList) {
			if (tweet.getTweetId() == i) {
				List<String> restrictUser = new LinkedList<String>();
				restrictUser.add(username);
				tweet.setRestrict(restrictUser);
			}
		}
	}

	private static boolean checkRestricted(String username, int i) {
		for (Tweets tweet : tweetsList) {
			if (tweet.getTweetId() == i) {
				List<String> restrictUser = tweet.getRestrict();
				for (String user : restrictUser) {
					if (user.equals(username)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static void deleteTweetByID(int tweetId, String string2) {
		Iterator<Tweets> iter = tweetsList.iterator();
		while (iter.hasNext()) {
			Tweets tweet = (Tweets) iter.next();
			if (tweet.getTweetId() == tweetId) {
				iter.remove();
			}
		}

	}

	private static void getUserFeedByUser(String user) {
		System.out.println("User feed for user " + user);
		List<String> result = new LinkedList<String>();
		for (Followers follower : followersList) {
			List<Users> tmpFollowers = follower.getFollowers();
			for (Users usr : tmpFollowers) {
				if (usr.getUsername() == user) {
					result.add(follower.getUser().username);
				}
			}
		}
		for (String st : result) {
			getTweetsByUser(st);
		}
	}

	private static void getTweetsByUser(String username) {
		System.out.println("Tweets by " + username);
		for (Tweets tweet : tweetsList) {
			tweet.getTweetsByUsername(username);
		}
	}

	public static void postTweet(String tweetMsg, String usrName) {
		Tweets tweet = new Tweets();
		tweet.setTweet(tweetMsg);
		tweet.setUserName(usrName);
		tweet.setTweetId(++tweetId);
		tweetsList.add(tweet);
		System.out.println("Tweet Msg : " + tweetMsg + "  Tweet Id: " + tweetId);
	}

	public static void addFollowers(Followers follow) {
		followersList.add(follow);
	}

	public static Users addUsers(String userName) {
		Users user = new Users();
		user.createUser(userName);
		userList.add(user);

		return user;
	}

}
