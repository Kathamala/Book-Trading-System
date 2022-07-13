package Repository;

import java.util.ArrayList;

import Entity.BookReview;

public class BookReviewRepository {
	private static ArrayList<BookReview> bookReviews;

	public static ArrayList<BookReview> getBookReviews() {
		return bookReviews;
	}

	public static void setBookReviews(ArrayList<BookReview> bookReviews) {
		BookReviewRepository.bookReviews = bookReviews;
	}
}
