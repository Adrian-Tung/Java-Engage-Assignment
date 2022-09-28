package com.sg.dvdlibrary.dto;

public class DVD {
	
	private String title;
	private String releaseDate; // format - "2022 May"
	private String mpaaRating;
	private String directorName;
	private String studio;
	private String userRating;
	
	public DVD(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getMpaaRating() {
		return mpaaRating;
	}
	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getUserRating() {
		return userRating;
	}
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}

	
	
	
	
}
