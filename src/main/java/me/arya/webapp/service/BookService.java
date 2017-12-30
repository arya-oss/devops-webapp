package me.arya.webapp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import me.arya.webapp.repository.BookRepository;
import org.apache.log4j.Logger;

import me.arya.webapp.domain.Book;

public class BookService {
	private static Logger logger = Logger.getLogger("BookService");
	private BookRepository bookRepository = new BookRepository();

	public List<Book> searchBookInGivenRange(final Date from, final Date to) {
		List<Book> result = bookRepository.selectAll();
		Calendar cal = Calendar.getInstance();
		cal.setTime(to);
		cal.add(Calendar.YEAR, 1);
		result = result.stream().filter(book -> book.getPublished().before(cal.getTime()) && book.getPublished().after(from))
				.collect(Collectors.toList());
		logger.info("filtered books");
		result.forEach(book -> logger.info(book));
		return result;
	}

	public void addBook(Book book) {
		logger.info("adding book to db " + book.getTitle());
		bookRepository.addBook(book);
	}
	
	public void updateBook(int id, Book book) {
		logger.info("update book to db " + id);
		bookRepository.updateBook(id, book);
	}
	
	public void deleteBook(int id) {
		logger.info("deleting book from db " + id);
		bookRepository.deleteBook(id);
	}
	
	public List<Book> selectAll() {
		List<Book> selectAll = bookRepository.selectAll();
		logger.info("selecting all books " + selectAll.size());
		return selectAll;
	}
	
	public Book findOne (int id) {
		logger.info("finding book in db " + id);
		return bookRepository.findOne(id);
	}
	
	public void truncateTable () {
		bookRepository.truncateTable();
	}
}
