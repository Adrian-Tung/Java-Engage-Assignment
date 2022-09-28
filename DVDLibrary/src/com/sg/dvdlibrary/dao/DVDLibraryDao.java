package com.sg.dvdlibrary.dao;

import java.util.List;

import com.sg.dvdlibrary.dto.DVD;

public interface DVDLibraryDao {

	
	DVD addDvd(String title, DVD dvd) throws DVDLibraryDaoException;
	
    List<DVD> getAllDvds() throws DVDLibraryDaoException;
	
    DVD getDvd(String title)throws DVDLibraryDaoException;
    
    DVD removeDvd(String Dvd)throws DVDLibraryDaoException;
    
    void modifyDvd(String title, DVD dvd)throws DVDLibraryDaoException;

}
