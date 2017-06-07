package org.hackathon1.aym.dataFetch;

import java.util.ArrayList;
import java.util.List;

import org.hackathon1.aym.model.Organization;
import org.hackathon1.aym.model.TwitterUser;
import org.hackathon1.aym.serialization.SerializationManager;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class FetchData {
	private static Twitter twitter = TwitterManager.getInstance().getTwitter();

	public static void main(String[] args) throws TwitterException {

		List<String> organizationIds = FileManager.getOrganizationIds();
		List<Organization> organizations = new ArrayList<>();

		for (int i = 0; i < organizationIds.size(); i++) {
			if (i == 10)
				break;
			Organization org = new Organization();
			org.setId(Long.parseLong(organizationIds.get(i)));
			System.out.println(org.getId());
			
			IDs followersIDs = twitter.getFollowersIDs(org.getId(), -1);
			long[] iDs = followersIDs.getIDs();
			for (long l : iDs) {
				TwitterUser newUser = new TwitterUser();
				newUser.setId(l);
				org.getFollowers().add(newUser);
			}
			
			
			
			organizations.add(org);
		}
		
		SerializationManager.getInstance().serializeObject(organizations, "test1");;

	}

}
