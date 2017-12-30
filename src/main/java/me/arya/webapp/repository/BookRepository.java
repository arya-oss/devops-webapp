package me.arya.webapp.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import me.arya.webapp.domain.Book;
import me.arya.webapp.utility.Constants;

import static me.arya.webapp.common.Database.getConnection;

public class BookRepository {
	
	private static final Logger logger = Logger.getLogger("BookRepository");
	private static String COL_ID = "id";
	private static String COL_TITLE = "title";
	private static String COL_AUTHOR = "author";
	private static String COL_PUBLISHED = "published";
	
	public void addBook (Book book) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(Constants.INSERTBOOKSQL);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setDate(3, new java.sql.Date(book.getPublished().getTime()));
			statement.execute();
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}
	
	public void updateBook (int id, Book book) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constants.UPDATEBOOKSQL);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDate(3, new java.sql.Date(book.getPublished().getTime()));
            statement.setInt(4, id);
            statement.execute();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
	}
	
	public void deleteBook (int id) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constants.DELETEONESQL);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
	}
	
	public List<Book> selectAll () {
		List<Book> books = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(Constants.SELECTALLSQL);
            result = statement.executeQuery();
        } catch (SQLException e) {
            logger.error(e);
        }
		try {
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getInt(COL_ID));
				book.setTitle(result.getString(COL_TITLE));
				book.setAuthor(result.getString(COL_AUTHOR));
				book.setPublished(result.getDate(COL_PUBLISHED));
				books.add(book);
			}
		} catch (SQLException e) {
			logger.error(e);
		} finally {
            try {
                result.getStatement().close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return books;
	}
	
	public Book findOne (int id) {
		Book book = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(Constants.SELECTONESQL);
            statement.setInt(1, id);
            result = statement.executeQuery();
        } catch (SQLException e) {
            logger.error(e);
        }

		try {
			while (result.next()) {
				book = new Book();
				book.setId(result.getInt(COL_ID));
				book.setTitle(result.getString(COL_TITLE));
				book.setAuthor(result.getString(COL_AUTHOR));
				book.setPublished(result.getDate(COL_PUBLISHED));
				break;
			}
		} catch (SQLException e) {
			logger.error(e);
		} finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
		return book;
	}

	public void truncateTable() {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constants.TRUNCATEBOOK);
            statement.execute();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }
}
