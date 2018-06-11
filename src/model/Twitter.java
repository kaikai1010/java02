package model;

public class Twitter implements java.io.Serializable {
	private String twitterName;
	private String text;

	public Twitter() {}
	public Twitter(String twitterName, String text) {
		this.twitterName = twitterName;
		this.text = text;
	}

	public String getTwitterName() {
		return twitterName;
	}
	public String getText() {
		return text;
	}

}
