/*
 * TwitterBot.java
 * 
 */

package poker.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterBot {

	private static TwitterBot twitterBot;
	private static Twitter api;

	// Authentication constants
	private static final String CONSUMER_KEY = "Ic58qS202Bx1FI49ldgPjxo0C";
	private static final String CONSUMER_SECRET = "iYliAn5FMWnhRkjkTpDQbihsLABETO3PcngFbVMAtZbRurxJf5";
	private static final String ACCESS_TOKEN = "849543733473406978-E67tu69fyczCmqEwQmUXZzG3qbEGG3i";
	private static final String ACCESS_TOKEN_SECRET = "mUPz8pdcEh6xIPsFwRr3yuA1cSJ0PvnFnjnAcQz0T0ufn";

	private TwitterBot() {}
	
	public static Twitter getAPI() {
		if (twitterBot == null) {
			twitterBot = new TwitterBot();
			initialize();
		}
		return api;
	}

	private static void initialize() {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true)
		.setOAuthConsumerKey(CONSUMER_KEY)
		.setOAuthConsumerSecret(CONSUMER_SECRET)
		.setOAuthAccessToken(ACCESS_TOKEN)
		.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		api = new TwitterFactory(configurationBuilder.build()).getInstance();
		TwitterListener.startListening();
	}

	public static void main(String[] args) {
		TwitterBot.getAPI();
	}

}