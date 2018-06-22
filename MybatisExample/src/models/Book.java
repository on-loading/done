package models;

public class Book {
	private int no;
	private String bookName;
	private String author;
	private int price;
	
	public Book(){}
	
	public Book(int no, String bookName, String author, int price) {
		super();
		this.no = no;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
