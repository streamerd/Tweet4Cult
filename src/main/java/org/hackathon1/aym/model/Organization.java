package org.hackathon1.aym.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Organization implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	
	private List<TwitterUser> followers= new ArrayList<>();
	private Set<TwitterUser> followersSet;
	
	public Set<TwitterUser> getFollowersSet() {
		if(followersSet == null)
			followersSet = new HashSet<>(followers);
		return followersSet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<TwitterUser> getFollowers() {
		return followers;
	}

	public void setFollowers(List<TwitterUser> followers) {
		this.followers = followers;
	}
}
