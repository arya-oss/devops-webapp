package me.arya.webapp.controller;

import me.arya.webapp.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class AddBookServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private BookService bookService;

    @InjectMocks
    private AddBookServlet addBookServlet;

    @Before
    public void setUp() {
        Assert.assertNotNull(addBookServlet);
        when(request.getParameter("title")).thenReturn("Wings of Fire");
        when(request.getParameter("author")).thenReturn("Dr. APJ Abdul Kalam");

    }
    @Test
    public void addBookTest () throws ParseException, IOException {
        when(request.getParameter("published")).thenReturn("2010-02-01");
        when(response.getWriter()).thenReturn(new PrintWriter(System.out));
        addBookServlet.doPost(request, response);
    }

    @Test
    public void addBookWrongDateFormatShouldThrowError () throws IOException {
        when(request.getParameter("published")).thenReturn("1st Feb 2010");
        when(response.getWriter()).thenReturn(new PrintWriter(System.out));
        addBookServlet.doPost(request, response);
    }

    @Test
    public void addBookResponseWriteNull () throws IOException{
        when(request.getParameter("published")).thenReturn("2010-02-01");
        when(response.getWriter()).thenThrow(new IOException("Error in getting InputStream from reponse"));
        addBookServlet.doPost(request, response);
    }
}
