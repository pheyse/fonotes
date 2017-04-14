package com.bright_side_it.fonotes.common.model;

public class NoteInfo {
	private String name;
	private String colorID;
	private long lastEditTime;
	private long creationTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColorID() {
		return colorID;
	}
	public void setColorID(String colorID) {
		this.colorID = colorID;
	}
	public long getLastEditTime() {
		return lastEditTime;
	}
	public void setLastEditTime(long lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	
}
