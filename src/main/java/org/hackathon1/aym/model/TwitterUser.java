package org.hackathon1.aym.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TwitterUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private int followerCount;
	private List<String> posts = new ArrayList<>();
	private int tweetCount;
	private int organizationFollowed;
	private String location;
	private float heuristicValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

	public List<String> getPosts() {
		return posts;
	}

	public void setPosts(List<String> posts) {
		this.posts = posts;
	}

	public int getTweetCount() {
		return tweetCount;
	}

	public void setTweetCount(int tweetCount) {
		this.tweetCount = tweetCount;
	}

	public void setOrganizationFollowed(int organizationFollowed) {
		this.organizationFollowed = organizationFollowed;
	}

	public int getOrganizationFollowed() {
		return organizationFollowed;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public float getHeuristicValue() {
		return heuristicValue;
	}
	
	public void setHeuristicValue(float heuristicValue) {
		this.heuristicValue = heuristicValue;
	}

	@Override
	public int hashCode() {
		return (int) id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id).append("\n");
		sb.append("followerCount: ").append(followerCount).append("\n");
		sb.append("relevantPostsCount: ").append(posts.size()).append("\n");
		sb.append("tweetCount: ").append(tweetCount).append("\n");
		sb.append("organizationFollowedCount: ").append(organizationFollowed).append("\n");
		sb.append("location: ").append(location).append("\n");
		sb.append("heuristicValue: ").append(heuristicValue).append("\n");
		return sb.toString();
	}

}
