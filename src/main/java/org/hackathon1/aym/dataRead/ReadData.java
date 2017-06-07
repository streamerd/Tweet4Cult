package org.hackathon1.aym.dataRead;

import java.util.List;

import org.hackathon1.aym.model.Organization;
import org.hackathon1.aym.model.TwitterUser;
import org.hackathon1.aym.serialization.SerializationManager;

public class ReadData {

	public static void main(String[] args) {
		List<Organization> deserializeListOfOrganizations = SerializationManager.getInstance()
				.deserializeListOfOrganizations("dummyOrganizations");
		
		for (Organization organization : deserializeListOfOrganizations) {
			List<TwitterUser> followers = organization.getFollowers();
			for (TwitterUser twitterUser : followers) {
				System.out.println(twitterUser.getFollowerCount());
			}
		}
	}
}
