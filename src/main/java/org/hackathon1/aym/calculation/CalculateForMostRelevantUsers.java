package org.hackathon1.aym.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hackathon1.aym.model.Organization;
import org.hackathon1.aym.model.TwitterUser;
import org.hackathon1.aym.serialization.SerializationManager;

public class CalculateForMostRelevantUsers {

	private static List<Organization> organizations;
	private static final String RELEVANT_LOCATION = "London, United Kingdom";

	public static void main(String[] args) {
		organizations = SerializationManager.getInstance().deserializeListOfOrganizations("dummyOrganizationsForRelevantTags");
		List<TwitterUser> allUsers = new ArrayList<>();
		for (Organization organization : organizations) {
			List<TwitterUser> followers = organization.getFollowers();
			for (TwitterUser twitterUser : followers) {
				setFollowingOrganizationsOfUser(twitterUser);
				setHeuristicValueOfUser(twitterUser);
				allUsers.add(twitterUser);
				twitterUser.getHeuristicValue();
			}
		}
		
		Collections.sort(allUsers, new Comparator<TwitterUser>() {

			@Override
			public int compare(TwitterUser o1, TwitterUser o2) {
				if (o1.getHeuristicValue() > o2.getHeuristicValue())
					return -1;
				else if (o1.getHeuristicValue() < o2.getHeuristicValue())
					return 1;

				return 0;
			}
		});

		for (int i = 0; i < 100; i++) {
			System.out.println(allUsers.get(i));
		}

	}

	private static void setFollowingOrganizationsOfUser(TwitterUser user) {
		int count = 0;
		for (Organization organization : organizations) {
			if (organization.getFollowersSet().contains(user)) {
				count++;
			}
		}
		user.setOrganizationFollowed(count);
	}

	public static void setHeuristicValueOfUser(TwitterUser user) {
		float tagsWeight = user.getPosts().size() * 30;
		float followerCountWeight = user.getFollowerCount() * .2f;
		float locationWeight = user.getLocation().equals(RELEVANT_LOCATION) ? 30 : 0;
		float tweetCountWeight = (float) Math.log10((double) user.getTweetCount());
		float organizationFollowedWeight = user.getOrganizationFollowed() * 10;

		float heuristicValue = tagsWeight + followerCountWeight + locationWeight + tweetCountWeight
				+ organizationFollowedWeight;
		user.setHeuristicValue(heuristicValue);
	}

}
