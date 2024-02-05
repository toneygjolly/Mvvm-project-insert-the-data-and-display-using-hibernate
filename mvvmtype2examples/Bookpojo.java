package mvvmtype2examples;
import javax.persistence.*;
@Entity
@Table(name="mvvmtype2")
public class Bookpojo {
	
	@Id
	@Column(name="bookId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	@Column
	private String bookname;
	@Column
	
	private String Author;

	@Column
	private double price;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getAuthor() {
	    return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	private String imageUrl;
	public void store() {
	Bookpojo d=new Bookpojo();
		d.setAuthor(Author);
		d.setBookname(bookname);
		d.setPrice(price);
		d.setImageUrl(imageUrl);
		new BookOperations().storeing(d);
	}
	
}
