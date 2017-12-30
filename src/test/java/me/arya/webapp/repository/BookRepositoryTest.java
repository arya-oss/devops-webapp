package me.arya.webapp.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import me.arya.webapp.domain.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest {

	@Mock
	BookRepository repo;

	private Book book;
	
	@Before
	public void setUp() throws Exception {
		assertNotNull(repo);
		
		book = new Book();
		book.setTitle("Revolution 2020");
		book.setAuthor("Chetan Bhagat");
		book.setPublished(new SimpleDateFormat("yyyy-MM-dd").parse("2008-02-01"));
		
		List<Book> books = new ArrayList<>();
		books.add(book);
		
		when(repo.findOne(1)).thenReturn(book);
		when(repo.selectAll()).thenReturn(books);
	}

	@Test
	public void addBookTest() throws ParseException {
		repo.addBook(book);
	}

	@Test
	public void findOneBookTest() {
		Book oneBook = repo.findOne(1);
		assertNotNull(oneBook);
		assertEquals(oneBook.getTitle(), "Revolution 2020");
	}

	@Test
	public void selectAllTest() {
		List<Book> books = repo.selectAll();
		assertEquals(books.size(), 1);
	}

	@Test
	public void updateBookTest() throws ParseException {
		Book book = new Book();
		book.setTitle("Revolution 2010");
		book.setAuthor("Chetan Bhagat");
		book.setPublished(new SimpleDateFormat("yyyy-MM-dd").parse("2008-02-01"));
		repo.updateBook(1, book);
	}

	@Test
	public void deleteBookTest() {
		repo.deleteBook(1);
	}

}
