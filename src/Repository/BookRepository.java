package Repository;

import java.util.ArrayList;

import Entity.Book;

public class BookRepository {
	private static ArrayList<Book> books;

	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static void setBooks(ArrayList<Book> books) {
		BookRepository.books = books;
	}
}
