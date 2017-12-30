package me.arya.webapp.utility;

public class Constants {

    protected Constants() {}

	static final String DBURLINIT = "jdbc:mysql://";
	static final String DBCONFFILE = "webapp.properties";
	static final String DBDRIVER = "driver";
	static final String DBHOST = "host";
	static final String DBPORT = "port";
	static final String DBUSER = "user";
	static final String DBPASS = "password";
	static final String DBNAME = "database";
	
	/* SQL Query Strings for Books */
	public static final String INSERTBOOKSQL = "insert into book (title, author, published) values(?, ?, ?)";
	public static final String UPDATEBOOKSQL = "update book set title=?, author=?, published=? where id=?";
	public static final String SELECTALLSQL = "select * from book";
	public static final String SELECTONESQL = "select * from book where id=?";
	public static final String DELETEONESQL = "delete from book where id=?";
	public static final String TRUNCATEBOOK = "truncate book";
}
