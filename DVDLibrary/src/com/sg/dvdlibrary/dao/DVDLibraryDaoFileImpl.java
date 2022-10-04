package com.sg.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sg.dvdlibrary.dto.DVD;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

	private Map<String, DVD> dvds = new HashMap<>();
	public static final String COLLECTION_FILE = "collection.txt";
	public static final String DELIMITER = "::";

	@Override
	public DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException {
		loadCollection();
		DVD newDvd = dvds.put(title, dvd);
		writeCollection();
		return newDvd;
	}

	@Override
	public List<DVD> getAllDvds() throws DVDLibraryDaoException {
		loadCollection();
		return new ArrayList<DVD>(dvds.values());
	}

	@Override
	public DVD getDvd(String title) throws DVDLibraryDaoException {
		loadCollection();
		return dvds.get(title);
	}

	@Override
	public DVD removeDvd(String title) throws DVDLibraryDaoException {
		loadCollection();
		DVD removedDvd = dvds.remove(title);
		writeCollection();
		return removedDvd;
	}

	@Override
	public void modifyDvd(String title, DVD dvd) throws DVDLibraryDaoException {
		loadCollection();
		dvds.put(title, dvd);
		writeCollection();
	}

	private DVD unmarshallDvd(String dvdAsText) {

		String[] dvdTokens = dvdAsText.split(DELIMITER);
		String title = dvdTokens[0];
		DVD dvdFromFile = new DVD(title);
		dvdFromFile.setReleaseDate(dvdTokens[1]);
		dvdFromFile.setMpaaRating(dvdTokens[2]);
		dvdFromFile.setDirectorName(dvdTokens[3]);
		dvdFromFile.setStudio(dvdTokens[4]);
		dvdFromFile.setUserRating(dvdTokens[5]);

		return dvdFromFile;
	}

	private void loadCollection() throws DVDLibraryDaoException {
		Scanner scanner;

		try {

			scanner = new Scanner(new BufferedReader(new FileReader(COLLECTION_FILE)));
		} catch (FileNotFoundException e) {
			throw new DVDLibraryDaoException("-_- Could not load roster data into memory.", e);
		}

		String currentLine;

		DVD currentDvd;

		while (scanner.hasNextLine()) {

			currentLine = scanner.nextLine();

			currentDvd = unmarshallDvd(currentLine);

			dvds.put(currentDvd.getTitle(), currentDvd);
		}
		// close scanner
		scanner.close();
	}

	private String marshallDvd(DVD aDVD) {

		String dvdAsText = aDVD.getTitle() + DELIMITER;
		dvdAsText += aDVD.getReleaseDate() + DELIMITER;
		dvdAsText += aDVD.getMpaaRating() + DELIMITER;
		dvdAsText += aDVD.getDirectorName() + DELIMITER;
		dvdAsText += aDVD.getStudio() + DELIMITER;
		dvdAsText += aDVD.getUserRating();

		return dvdAsText;
	}

	private void writeCollection() throws DVDLibraryDaoException {

		PrintWriter out;

		try {
			out = new PrintWriter(new FileWriter(COLLECTION_FILE));
		} catch (IOException e) {
			throw new DVDLibraryDaoException("Could not save DVD data.", e);
		}

		String dvdAsText;

		List<DVD> dvdList = new ArrayList<DVD>(dvds.values());
		for (DVD currentDvd : dvdList) {

			dvdAsText = marshallDvd(currentDvd);
			out.println(dvdAsText);
			out.flush();
		}
		out.close();
	}

}
