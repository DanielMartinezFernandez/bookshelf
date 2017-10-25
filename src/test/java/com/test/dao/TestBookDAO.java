package com.test.dao;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.test.config.ObjectifyConfig;
import com.test.data.Book;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBookDAO {
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	private BookDAO bookDAO = new BookDAO();
	
	@Before
	public void setUp() {
		helper.setUp();

		try {
			Class.forName(ObjectifyConfig.class.getName()).newInstance();
		} catch (ClassNotFoundException ex) {
			System.out.println("Error ClassNotFoundException {0}");
		} catch (IllegalAccessException ex) {
			System.out.println("Error IllegalAccessException {0}");
		} catch (InstantiationException ex) {
			System.out.println("Error InstantiationException {0}");
		}
	}
	


	@Test
	public void saveTest() {
		System.out.println(" Creación datos");
		saveData();
		deletetData();
	}
	
	
	
    @Test
    public void listTest() {
    	List<Book> list;
    	
    	saveData();
    	list = bookDAO.list();
    	System.out.println("Listado de libros");  
      
        for (Book book : list) {
        	System.out.println(book.getTitle());
        }
        
        deletetData();
    }
    
    @Test
    public void getTest() {
    	List<Book> list;
    	Book resultBook; 
    	
    	saveData();
    	list = bookDAO.list();
    	System.out.println("get Libro");  
      
		for (Book book : list) {
			resultBook = bookDAO.get(book.getId());
			
			System.out.println(resultBook.getTitle());
		}
		
		deletetData();
    }
    
    @Test
    public void deletetTest() {
      List<Book> list;
      
      saveData();
      System.out.println("delete Libro");  
      deletetData();
      
      list = bookDAO.list();  
      System.out.println(list.size() + " libros devueltos");
    }
    
	@After
	public void tearDown() {
		helper.tearDown();
	}
	
	private void saveData() {
		Book test1;
		Book test2;
		Book test3;
		Book test4;
		Book test5;
		DateFormat format;
	
		test1 = new Book();
		test2 = new Book();
		test3 = new Book();
		test4 = new Book();
		test5 = new Book();
		format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		
		try {	
		
		test1.setTitle("A Game of Thrones");
		test1.setAuthor("George R. R. Martin");
		test1.setGender("Novela: fantasía");
		test1.setPublicationDate(format.parse("06/08/1996 00:00:00"));		
		
		test2.setTitle("A Clash of Kings");
		test2.setAuthor("George R. R. Martin");
		test2.setGender("Novela: fantasía");
		test2.setPublicationDate(format.parse("16/11/1996 00:00:00"));		
		
		test3.setTitle("A Storm of Swords");
		test3.setAuthor("George R. R. Martin");
		test3.setGender("Novela: fantasía");
		test3.setPublicationDate(format.parse("08/08/2000 00:00:00"));		
		
		test4.setTitle("A Feast for Crows");
		test4.setAuthor("George R. R. Martin");
		test4.setGender("Novela: fantasía");
		test4.setPublicationDate(format.parse("17/10/2005 00:00:00"));
		
		test5.setTitle("A Dance with Dragons");
		test5.setAuthor("George R. R. Martin");
		test5.setGender("Novela: fantasía");
		test5.setPublicationDate(format.parse("12/07/2011 00:00:00"));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookDAO.save(test1);
		System.out.println(test1.getTitle() + " creado");
		bookDAO.save(test2);
		System.out.println(test2.getTitle() + " creado");
		bookDAO.save(test3);
		System.out.println(test3.getTitle() + " creado");
		bookDAO.save(test4);
		System.out.println(test4.getTitle() + " creado");
		bookDAO.save(test5);
		System.out.println(test5.getTitle() + " creado");

		try {
			bookDAO.save(null);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage() + " Ok");
		}
	}
	
    private void deletetData() {
        List<Book> list = bookDAO.list();        
          for (Book book : list) {
          	bookDAO.delete(book);
          	System.out.println(book.getTitle() + " borrado");
          }
    }
	
}
