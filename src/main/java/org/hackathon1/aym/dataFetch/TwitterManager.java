package org.hackathon1.aym.dataFetch;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterManager {

	private static TwitterManager instance;
	private Twitter twitter;

	public static TwitterManager getInstance() {
		if (instance == null)
			instance = new TwitterManager();
		return instance;
	}

	private TwitterManager() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("FSFYd8YIDDHvZGHL6aaEWb1qg")
				.setOAuthConsumerSecret("deuzi1vtXhxT6g4nAnu11vBiwT2jnUTf0MzdmvG4XSXWfnreJo")
				.setOAuthAccessToken("93004280-jOIElZjIqd7vT4G67xZRYdDHx0l094XNCV8Z7xaqo")
				.setOAuthAccessTokenSecret("ooJAOzZSPwtbDjC0g8KsT4sTkvwmwABEA2qbHGuAVuBH4");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

	public Twitter getTwitter() {
		return twitter;
	}

	public static void main(String[] args) {
		Twitter twitter2 = TwitterManager.getInstance().getTwitter();
		try {
			User showUser = twitter2.showUser(633703297);
			String name = showUser.getName();
			System.out.println(name);
			showUser.getLocation();

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
