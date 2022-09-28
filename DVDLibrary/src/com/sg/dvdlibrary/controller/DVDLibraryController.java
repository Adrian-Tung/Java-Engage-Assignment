package com.sg.dvdlibrary.controller;

import java.util.List;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class DVDLibraryController {

	private DVDLibraryView view;
	private DVDLibraryDao dao;

	public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
		this.dao = dao;
		this.view = view;
	}

	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}

	private void removeDvd() throws DVDLibraryDaoException {
		view.displayRemoveDvdBanner();
		String title = view.getDvdTitleChoice();
		DVD removedDvd = dao.removeDvd(title);
		view.displayRemoveResult(removedDvd);
	}

	private void addDvd() throws DVDLibraryDaoException {
		view.displayAddDvdBanner();
		DVD newDvd = view.getNewDvdInfo();
		dao.addDvd(newDvd.getTitle(), newDvd);
		view.displayAddSuccessBanner();
	}

	private void listDvds() throws DVDLibraryDaoException {
		view.displayDisplayAllBanner();
		List<DVD> dvdList = dao.getAllDvds();
		view.displayDvdList(dvdList);
	}

	private void searchAndviewDvd() throws DVDLibraryDaoException {
		view.displayDisplayDvdBanner();
		String title = view.getDvdTitleChoice();
		DVD dvd = dao.getDvd(title);
		view.displayDvd(dvd);

	}

	public void modifyDvd() throws DVDLibraryDaoException {
		view.displayModifyDvdBanner();
		String title = view.getDvdTitleChoice();
		DVD dvd = dao.getDvd(title);
		view.displayDvd(dvd);
		if (dvd != null) {
			DVD newDvd = view.getModifyDVDInfo(title);
			dao.modifyDvd(title, newDvd);
			view.displayDvd(newDvd);
			view.displayModifySuccessBanner();

		}
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		view.displayExitBanner();
	}

	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;
		try {
			while (keepGoing) {
				menuSelection = getMenuSelection();

				switch (menuSelection) {
				case 1:
					listDvds();
					break;
				case 2:
					addDvd();
					break;
				case 3:
					removeDvd();
					break;
				case 4:
					modifyDvd();
					break;
				case 5:
					searchAndviewDvd();
					break;
				case 6:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}

			}
			exitMessage();
		} catch (DVDLibraryDaoException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}
}