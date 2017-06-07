package org.hackathon1.aym.dataFetch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	private static final String ORG_NAME_FILE = "orgNames.txt";
	private static final String ORG_ID_FILE = "orgIds.txt";
	private static final String RELEVANT_TAGS = "tagsList.txt";
	private static final String EVENTS_LIST = "eventsList.txt";
	private static final String LOCATIONS = "locations.txt";



	private static List<String> getLinesFromFile(String filePath) {
		List<String> names = new ArrayList<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (br.ready()) {
				names.add(br.readLine());
			}
			br.close();
			return names;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return names;

	}
	public static List<String> getEventsList(){
		return getLinesFromFile(EVENTS_LIST);
	}
	
	public static List<String> getLocations(){
		return getLinesFromFile(LOCATIONS);
	}

	public static List<String> getRelevantTags() {
		return getLinesFromFile(RELEVANT_TAGS);
	}

	public static List<String> getOrganizationNames() {
		return getLinesFromFile(ORG_NAME_FILE);
	}

	public static List<String> getOrganizationIds() {
		return getLinesFromFile(ORG_ID_FILE);
	}
}
