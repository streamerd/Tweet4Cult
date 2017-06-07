package org.hackathon1.aym.dataRead;

import java.util.List;
import java.util.Random;

import org.hackathon1.aym.dataFetch.FileManager;
import org.hackathon1.aym.model.Organization;
import org.hackathon1.aym.model.TwitterUser;
import org.hackathon1.aym.serialization.SerializationManager;

public class MakeDummyData {
	

	public static void main(String[] args) {
		Random r = new Random();
		List<Organization> deserializeListOfOrganizations = SerializationManager.getInstance()
				.deserializeListOfOrganizations("test1");
		
		List<String> relevantTags = FileManager.getRelevantTags();
		List<String> locations = FileManager.getLocations();
		
		for (Organization organization : deserializeListOfOrganizations) {
			List<TwitterUser> followers = organization.getFollowers();
			for (TwitterUser twitterUser : followers) {
				
				for (String tag : relevantTags) {
					int nextInt = r.nextInt(100);
					if(nextInt == 1){
						twitterUser.getPosts().add(tag);
					}
				}
				
				twitterUser.setFollowerCount(r.nextInt(1000));
				twitterUser.setTweetCount(r.nextInt(10000));
				//TODO
				twitterUser.setLocation(locations.get(r.nextInt(locations.size())));
			}
		}
		
		SerializationManager.getInstance().serializeObject(deserializeListOfOrganizations, "dummyOrganizationsForRelevantTags");
	}

}
