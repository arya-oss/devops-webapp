package me.arya.webapp.integrationtest;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import me.arya.webapp.domain.Book;
import me.arya.webapp.service.BookService;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookSearchSteps {
	List<Book> result;
	BookService bookService = new BookService();
	
	@Given (".+book with the title '(.+)', written by '(.+)', published in (.+)")
	public void addNewBook(final String title, final String author, @Format("yyyy-MM-dd") final Date published) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublished(published);
		bookService.addBook(book);
	}

	@When ("^the customer searches for books published between (\\d+) and (\\d+)$")
	public void setSearchParameters(@Format("yyyy") final Date from, @Format("yyyy") final Date to) {
		result = bookService.searchBookInGivenRange(from, to);
	}

	@Then ("(\\d+) books should have been found$")
	public void verifyAmountOfBooksFound(final int booksFound) {
		assertThat(result.size(), equalTo(booksFound));
	}

	@Then ("Book (\\d+) should have the title '(.+)'$")
	public void verifyBookAtPosition(final int id, final String title) {
		assertThat(result.stream().filter(book -> book.getId() == id).findFirst().get().getTitle(), equalTo(title));
	}
	@Then("clear book table")
	public void truncateTable() {
		bookService.truncateTable();
	}
}
