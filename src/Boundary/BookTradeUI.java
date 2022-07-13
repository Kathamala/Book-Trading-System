package Boundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.GenerateBookTradeController;
import Entity.Address;
import Entity.Book;
import Entity.BookReview;
import Entity.BookTrade;
import Entity.User;
import Repository.BookRepository;
import Repository.BookReviewRepository;
import Repository.UserRepository;

public class BookTradeUI {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Trade Offer Activated!");
		GenerateBookTradeController btc = new GenerateBookTradeController();
		
		populateBooks();
		populateUsers();
		populateReviews();
		
		btc.activateTradeOffer(UserRepository.getUsers().get(0));
	}
	
	public static boolean sendTradeOffer(BookTrade bt) {
		boolean accepted = false;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//Ask to user 1:
		System.out.println("Hi, " + bt.getUser1().getUsername() + "! " + "Please, check out this trade offer:");
		System.out.println("You give: " + bt.getBook1().getName() + " to " + bt.getUser2().getUsername());
		System.out.println(bt.getUser2().getUsername() + " gives to you: " + bt.getBook2().getName());
		String response = ""; 
			
		while(!response.toLowerCase().equals("y") && !response.toLowerCase().equals("n")) {
			System.out.println("Do you accept this trade offer? (y/n)");
			response = sc.nextLine();
		}
		
		accepted = response.toLowerCase().equals("y");
		
		if(!accepted) return false; 
		
		//Ask to user 2:
		System.out.println("Hi, " + bt.getUser2().getUsername() + "! " + "Please, check out this trade offer:");
		System.out.println("You give: " + bt.getBook2().getName() + " to " + bt.getUser1().getUsername());
		System.out.println(bt.getUser1().getUsername() + " gives to you: " + bt.getBook1().getName());
		response = ""; 
			
		while(!response.toLowerCase().equals("y") && !response.toLowerCase().equals("n")) {
			System.out.println("Do you accept this trade offer? (y/n)");
			response = sc.nextLine();
		}
		
		accepted = response.toLowerCase().equals("y");
		
		return accepted;
	}
	
	public static void sendTrackingCodes(String trackingCodes) {
		System.out.println("Congratulations!");
		System.out.println(trackingCodes);
		return;
	}
		
	static void populateUsers() {
		ArrayList<User> users = new ArrayList<User>();
		
		User u1 = new User();
		u1.setUsername("User 1");
		u1.setAge(18);
		
		Address a1 = new Address();
		a1.setCep("XXXXX-001");
		a1.setCity("City 1");
		a1.setComplement("Complement 1");
		a1.setNumber(1);
		a1.setState("State 1");
		a1.setStreet("Street 1");
		u1.setAddress(a1);
		
		ArrayList<Book> wishlist1 = new ArrayList<Book>();
		wishlist1.add(BookRepository.getBooks().get(0));
		wishlist1.add(BookRepository.getBooks().get(1));
		u1.setWishlist(wishlist1);
		
		ArrayList<Book> booksToTrade1 = new ArrayList<Book>();
		booksToTrade1.add(BookRepository.getBooks().get(2));
		booksToTrade1.add(BookRepository.getBooks().get(3));
		u1.setBooksToTrade(booksToTrade1);
		
		users.add(u1);
		
		User u2 = new User();
		u2.setUsername("User 2");
		u2.setAge(20);
		
		Address a2 = new Address();
		a2.setCep("XXXXX-002");
		a2.setCity("City 2");
		a2.setComplement("Complement 2");
		a2.setNumber(2);
		a2.setState("State 2");
		a2.setStreet("Street 2");
		u2.setAddress(a2);
		
		ArrayList<Book> wishlist2 = new ArrayList<Book>();
		wishlist2.add(BookRepository.getBooks().get(2));
		wishlist2.add(BookRepository.getBooks().get(3));
		u2.setWishlist(wishlist2);
		
		ArrayList<Book> booksToTrade2 = new ArrayList<Book>();
		booksToTrade2.add(BookRepository.getBooks().get(0));
		booksToTrade2.add(BookRepository.getBooks().get(1));
		u2.setBooksToTrade(booksToTrade2);
		
		users.add(u2);
		
		UserRepository.setUsers(users);
	}
	
	static void populateBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		Book b1 = new Book();
		b1.setAuthor("F. Scott Fitzgerald");
		b1.setIsbn("1");
		b1.setName("O Grande Gatsby");
		b1.setYear("1925");
		books.add(b1);
		
		Book b2 = new Book();
		b2.setAuthor("J. K. Rowling");
		b2.setIsbn("2");
		b2.setName("Harry Potter e a Ordem da Fênix");
		b2.setYear("2003");
		books.add(b2);
		
		Book b3 = new Book();
		b3.setAuthor("J. R. R. Tolkien");
		b3.setIsbn("3");
		b3.setName("O Senhor dos Anéis");
		b3.setYear("1954");
		books.add(b3);
		
		Book b4 = new Book();
		b4.setAuthor("Ralph Ellison");
		b4.setIsbn("4");
		b4.setName("Homem Invisível");
		b4.setYear("1952");
		books.add(b4);
		
		Book b5 = new Book();
		b5.setAuthor("Miguel de Cervantes");
		b5.setIsbn("5");
		b5.setName("Dom Quixote");
		b5.setYear("1605");
		books.add(b5);
		
		BookRepository.setBooks(books);
	}
	
	static void populateReviews() {
		ArrayList<BookReview> bookReviews = new ArrayList<BookReview>();
		
		BookReview br1 = new BookReview();
		br1.setDescription("Very Good!");
		br1.setIsbn("1");
		br1.setScore(9.5f);
		br1.setUser(UserRepository.getUsers().get(0));
		
		bookReviews.add(br1);
		
		BookReview br2 = new BookReview();
		br2.setDescription("Ok");
		br2.setIsbn("3");
		br2.setScore(7f);
		br2.setUser(UserRepository.getUsers().get(0));
		
		bookReviews.add(br2);
		
		BookReview br3 = new BookReview();
		br3.setDescription("Meh");
		br3.setIsbn("2");
		br3.setScore(5f);
		br3.setUser(UserRepository.getUsers().get(1));
		
		bookReviews.add(br3);
		
		BookReview br4 = new BookReview();
		br4.setDescription("Very Good!");
		br4.setIsbn("4");
		br4.setScore(9f);
		br4.setUser(UserRepository.getUsers().get(1));
		
		bookReviews.add(br4);
		
		BookReviewRepository.setBookReviews(bookReviews);
	}

}

























