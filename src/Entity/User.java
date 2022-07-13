package Entity;

import java.util.ArrayList;

public class User {

	String username;
	Integer age;
	Address address;
	ArrayList<Book> wishlist;
	ArrayList<Book> booksToTrade;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ArrayList<Book> getWishlist() {
		return wishlist;
	}
	public void setWishlist(ArrayList<Book> wishlist) {
		this.wishlist = wishlist;
	}
	public ArrayList<Book> getBooksToTrade() {
		return booksToTrade;
	}
	public void setBooksToTrade(ArrayList<Book> booksToTrade) {
		this.booksToTrade = booksToTrade;
	}
}
