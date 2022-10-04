package com.sg.dvdlibrary.ui;

import java.util.List;

import com.sg.dvdlibrary.dto.DVD;

public class DVDLibraryView {

	private UserIO io;

	public DVDLibraryView(UserIO io) {
		this.io = io;
	}

	public DVD getNewDvdInfo() {
		String title = io.readString("Please enter DVD title");
		String releaseDate = io.readString("Please enter the release date");
		String mpaaRating = io.readString("Please enter DVD MPAA rating");
		String directorName = io.readString("Please enter director name");
		String studio = io.readString("Please enter Studio name");
		String userRating = io.readString("Please enter your rating/note");

		DVD currentDvd = new DVD(title);
		currentDvd.setReleaseDate(releaseDate);
		currentDvd.setMpaaRating(mpaaRating);
		currentDvd.setDirectorName(directorName);
		currentDvd.setStudio(studio);
		currentDvd.setUserRating(userRating);
		return currentDvd;
	}

	public DVD getModifyDVDInfo(String title) {
		io.print("Enter new DVD information to edit DVD");
		String releaseDate = io.readString("Please enter release date");
		String mpaaRating = io.readString("Please enter DVD MPAA rating");
		String directorName = io.readString("Please enter director name");
		String studio = io.readString("Please enter Studio name");
		String userRating = io.readString("Please enter your rating/note");

		DVD modifiedDvd = new DVD(title);
		modifiedDvd.setReleaseDate(releaseDate);
		modifiedDvd.setMpaaRating(mpaaRating);
		modifiedDvd.setDirectorName(directorName);
		modifiedDvd.setStudio(studio);
		modifiedDvd.setUserRating(userRating);
		return modifiedDvd;
	}

	public void displayAddDvdBanner() {
		io.print("=== Add DVD ===");
	}

	public void displayAddSuccessBanner() {
		io.readString("DVD added successfully!  Please hit enter to continue");
	}

	public void displayModifySuccessBanner() {
		io.readString("DVD modified successfully!  Please hit enter to continue");
	}

	public void displayDvdList(List<DVD> dvdList) {
		for (DVD currentDvd : dvdList) {
			String dvdInfo = String.format(
					"Title: %s" + "\nRelease Date: %s" + "\nMPAA Rating: %s" + "\nDirector Name: %s" + "\nStudio: %s"
							+ "\nUser rating: %s" + "\n=======================",
					currentDvd.getTitle(), currentDvd.getReleaseDate(), currentDvd.getMpaaRating(),
					currentDvd.getDirectorName(), currentDvd.getStudio(), currentDvd.getUserRating());
			io.print(dvdInfo);
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayDisplayAllBanner() {
		io.print("=== Display All DVD ===");
	}

	public void displayDisplayDvdBanner() {
		io.print("=== Search/Display DVD ===");
	}

	public void displayRemoveDvdBanner() {
		io.print("=== Remove DVD ===");
	}

	public void displayModifyDvdBanner() {
		io.print("=== Modify DVD ===");
	}

	public void displayRemoveResult(DVD dvdRecrod) {
		if (dvdRecrod != null) {
			io.print("DVD successfully removed.");
		} else {
			io.print("No such DVD.");
		}
		io.readString("Please hit enter to continue.");
	}

	public String getDvdTitleChoice() {
		return io.readString("Please enter the DVD title.");
	}

	public void displayDvd(DVD dvd) {
		if (dvd != null) {
			String dvdInfo = String.format(
					"Title: %s" + "\nRelease Date: %s" + "\nMPAA Rating: %s" + "\nDirector Name: %s" + "\nStudio: %s"
							+ "\nUser rating: %s",
					dvd.getTitle(), dvd.getReleaseDate(), dvd.getMpaaRating(), dvd.getDirectorName(), dvd.getStudio(),
					dvd.getUserRating());
			io.print(dvdInfo);
			io.print("");
		} else {
			io.print("No such DVD title.");
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayExitBanner() {
		io.print("Good Bye!!!");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown Command!!!");
	}

	public void displayErrorMessage(String errorMsg) {
		io.print("=== ERROR ===");
		io.print(errorMsg);
	}

	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. List DVD titles in collection");
		io.print("2. Add new DVD to collection");
		io.print("3. Remove DVD from collection");
		io.print("4. Modify existing DVD information in collection");
		io.print("5. Search for a DVD and display information");
		io.print("6. Exit");

		return io.readInt("Please select from the above choices.", 1, 6);
	}

}
