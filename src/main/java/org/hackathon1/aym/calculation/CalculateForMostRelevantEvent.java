package org.hackathon1.aym.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hackathon1.aym.model.Organization;
import org.hackathon1.aym.model.TwitterUser;
import org.hackathon1.aym.serialization.SerializationManager;

public class CalculateForMostRelevantEvent {
	private static List<Organization> organizations = SerializationManager.getInstance()
			.deserializeListOfOrganizations("dummyOrganizationsForEvents");
	private static Map<String, Integer> eventCounts = new HashMap<>();

	public static void main(String[] args) {
		for (Organization organization : organizations) {
			for (TwitterUser twitterUser : organization.getFollowers()) {
				for (String post : twitterUser.getPosts()) {
					addCountToEvent(post);
				}
			}
		}

		Set<Entry<String, Integer>> entrySet = eventCounts.entrySet();
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});

		for (Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}

	private static void addCountToEvent(String eventName) {
		if (!eventCounts.containsKey(eventName)) {
			eventCounts.put(eventName, 1);
			return;
		}
		eventCounts.put(eventName, eventCounts.get(eventName) + 1);

	}
}
