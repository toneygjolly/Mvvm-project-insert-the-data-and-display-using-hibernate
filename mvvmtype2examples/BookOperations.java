package mvvmtype2examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;

import searchmvvm.Book_Pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookOperations{
	private SessionFactory fact;
	 private SessionFactory sesfact;
	 private Session ses;
	private List<Bookpojo> listall;
	private List<Bookpojo> search;
	private List<Bookpojo> selectboxm;
	private Scanner sc;
	//private Object d;
	
	public BookOperations()
	{
		sesfact = DataConnect.getConnection();
		selectboxm=new ArrayList<Bookpojo>();
		listall=new ArrayList<Bookpojo>();
		search=new ArrayList<Bookpojo>();
		//sc=new Scanner(System.in);
	}
	

	
	public List<Bookpojo> findAllBook() {
		
        ses=sesfact.openSession();
	    ses.beginTransaction();
		Query query=ses.createQuery("select b from Bookpojo b");
		listall=query.list();
//		for(Book_Pojo l:list)
//		{
//			
////			System.out.println(""+l.getBookId());
////			System.out.println(""+l.getBookname());
////			System.out.println(""+l.getAuthor());
////			System.out.println(""+l.getPrice());	
////			System.out.println(""+l.getImageUrl());
//			
//		}
		return listall;
		
	}
	public void insertBooks() {
		ses=sesfact.openSession();
	    ses.beginTransaction();
	    Bookpojo BP=new Bookpojo();
	    BP.setBookId(3);
	    BP.setBookname("HORRORS OF THE NIGHT");
	    BP.setAuthor("joy");
	    BP.setPrice(300);
	   BP.setImageUrl("3.jpeg");
	    ses.save(BP);
	    ses.getTransaction().commit();
	
	}

	
	public List<Bookpojo> findBook(String keyword) {
		ses=sesfact.openSession();
	    ses.beginTransaction();
	    Query query = ses.createQuery("select b from Bookpojo b");
	    List<Bookpojo> listing = query.list();
	    String lowercase = keyword.toLowerCase();
	    for (Bookpojo BP : listing) 
	    {
	        if (BP.getBookname().toLowerCase().contains(lowercase)) 
	        {
	            search.add(BP);
	        }
	    }

	    return search;
	}
public void storeing(Bookpojo d) {
	ses=sesfact.openSession();
    ses.beginTransaction();
  
   
    ses.save(d);
    ses.getTransaction().commit();
    
    
}
	
//public List<Book_Pojo>selectionboxchecking(){
//	ses=sesfact.openSession();
//    ses.beginTransaction();
//    Query query = ses.createQuery("select b.bookname from Bookpojo b");
//    //List<String> bookNames = query.list();
//    selectboxm =query.list();
//    for(Book_Pojo m: selectboxm) {
//    	System.out.println("name"+m.getBookname());
//    	
//    }
//	return selectboxm;
//	
//}
//public List<String> selectionboxchecking() {
//    ses = sesfact.openSession();
//    ses.beginTransaction();
//    Query<String> query = ses.createQuery("select b.bookname from Bookpojo b", String.class);
//    List<String> bookNames = query.list();
//
//    for (String bookName : bookNames) {
//        System.out.println("name: " + bookName);
//    }
//    return bookNames;
//}

	public static void main(String[] args) {
		BookOperations m=new BookOperations();
		//m.insertBooks();
		//m.storeing();
//		//m.findAll();
		//m.selectionboxchecking();
		
		
}
	
	//}

}
