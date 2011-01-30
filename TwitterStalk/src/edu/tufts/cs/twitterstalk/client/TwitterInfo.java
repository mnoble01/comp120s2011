package edu.tufts.cs.twitterstalk.client;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.util.ArrayList;

public class TwitterInfo implements IsSerializable
{
	private static final String UNKNOWN = "Unknown";
	private String username;
	private String firstName;
	private String lastName;
	private ArrayList <TwitterInfo> followers;
	private String lat;
	private String lng;
	private String imgUrl;
	private String email;
	
	public TwitterInfo()
	{
		username = UNKNOWN;
		followers = new ArrayList <TwitterInfo>();
	}
		
	public TwitterInfo (String username)
	{
		this.username = username;
		followers = new ArrayList <TwitterInfo>();
	}

	public TwitterInfo (String username, String firstName, String lastName)
	{
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		followers = new ArrayList <TwitterInfo>();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<TwitterInfo> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<TwitterInfo> followers) {
		this.followers = followers;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static void main (String [] args)
	{
		TwitterInfo info = new TwitterInfo("tufts_cs_mchow", "Ming", "Chow");
		System.out.println("Followers for " + info.getFirstName() + " " + info.getLastName() + " (" + info.getUsername() + ")");
	}
}
