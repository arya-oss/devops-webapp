package me.arya.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import me.arya.webapp.domain.Book;
import me.arya.webapp.service.BookService;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger("AddBookServlet");
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookService();

	@Override
	protected final void doPost (HttpServletRequest request, HttpServletResponse response) {
		logger.info("entered doPost..");
		PrintWriter writer = null;
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Date published = null;

		try {
            writer = response.getWriter();
			published = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("published"));
		} catch (ParseException e) {
            logger.error(e);
            if (writer != null) {
                writer.print(e.getMessage());
                writer.flush();
            }
		} catch (IOException e) {
			logger.error(e);
		}
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublished(published);
		bookService.addBook(book);
		if (writer != null) {
            writer.write("successfully added");
            writer.flush();
        }
		logger.info("exited doPost..");
	}
}
