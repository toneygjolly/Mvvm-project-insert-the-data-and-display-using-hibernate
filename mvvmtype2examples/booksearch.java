package mvvmtype2examples;

import java.util.List;

import org.apache.catalina.Store;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import searchmvvm.Book_Pojo;



public class booksearch {
	private List<Bookpojo>store;
	
	
	public List<Bookpojo> getStore() {
		return store;
	}
	public void setStore(List<Bookpojo> store) {
		this.store = store;
	}
	//private String bookName;
	private Bookpojo selectedbook;

	
	
	
	
	public Bookpojo getSelectedbook() {
		return selectedbook;
	}
	public void setSelectedbook(Bookpojo selectedbook) {
		this.selectedbook = selectedbook;
	}
	private List<Bookpojo>booking;
	private String keys;
	
	
	
	public List<Bookpojo> getBooking() {
		return booking;
	}
	public void setBooking(List<Bookpojo> booking) {
		this.booking = booking;
	}
	
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	public String getKey() {
		return keys;
	}
	public void setKey(String key) {
		this.keys = key;
	}
	
	
	 @Command
	    @NotifyChange("booking")
	    public void search() {
	        BookOperations bo = new BookOperations();
	        booking = bo.findBook(keys);
	    }
	 @Command
	    @NotifyChange("booking")
	 public void Alldata() {
		 BookOperations bo = new BookOperations();
		 booking =bo.findAllBook();
	 }
//	 @Command
//	    @NotifyChange("store")
//	 public void store() {
//		 BookOperations b = new BookOperations();
//		 selectedbook =b.selectionboxchecking();
//	 }

}
