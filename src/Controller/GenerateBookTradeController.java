package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Boundary.APICorreios;
import Boundary.BookTradeUI;
import Entity.Book;
import Entity.BookReview;
import Entity.BookTrade;
import Entity.User;
import Repository.BookReviewRepository;
import Repository.UserRepository;

public class GenerateBookTradeController {

	public void activateTradeOffer(User u) 
	{
		ArrayList<BookReview> reviews = BookReviewRepository.getBookReviews();
		ArrayList<User> allUsers = UserRepository.getUsers();
		
		Map<User, ArrayList<Book>> possibleTrades = findUsersWithCloseReviewsAndBookInWishlist(reviews, allUsers, u);
		BookTrade bestMatch = findBestMatch(reviews, possibleTrades, u);
		
		while(bestMatch != null) {			
			boolean accepted = BookTradeUI.sendTradeOffer(bestMatch);
			
			if(accepted) {
				String trackingCodes = APICorreios.sendBooks(bestMatch);
				BookTradeUI.sendTrackingCodes(trackingCodes);
				return;
			}
			else {
				if(possibleTrades.get(bestMatch.getUser2()).size() == 1) {
					possibleTrades.remove(bestMatch.getUser2());
					
				}
				else {
					possibleTrades.get(bestMatch.getUser2()).remove(bestMatch.getBook2());
				}
				
				bestMatch = findBestMatch(reviews, possibleTrades, u);
			}
		}
		
		System.out.println("No matches found!");
		return;
	}
	
	
	Map<User, ArrayList<Book>> findUsersWithCloseReviewsAndBookInWishlist(ArrayList<BookReview> reviews, ArrayList<User> allUsers, User user) {
		Map<User, ArrayList<Book>> matchesFound = new HashMap<User, ArrayList<Book>>();
		
		for(User u : allUsers){
			if(u.getUsername() != user.getUsername()) {
				
				// Regra para checar compatibilidade.
				// Por enquanto, a regra não considera reviews próximas. 
				// Apenas se um livro de u2 está na wishlist do u1.
				for(Book b : user.getWishlist()){
					if(u.getBooksToTrade().contains(b)) {
						if(matchesFound.containsKey(u)){
							matchesFound.get(u).add(b);
						}
						else {
							ArrayList<Book> books = new ArrayList<Book>();
							books.add(b);
							matchesFound.put(u, books);
						}
					}
				}
			}
		}
		
		return matchesFound;
	}
	
	BookTrade findBestMatch(ArrayList<BookReview> reviews, Map<User, ArrayList<Book>> possibleTrades, User user) {
		BookTrade bt = new BookTrade();
		bt.setUser1(user);
		
		for(Map.Entry<User, ArrayList<Book>> u : possibleTrades.entrySet()){
			if(u.getKey().getUsername() != user.getUsername()) {
				
				// Regra para checar compatibilidade.
				// Por enquanto, a regra não considera reviews próximas. 
				// Apenas se um livro de u2 está na wishlist do u1.
				for(Book b : u.getKey().getWishlist()){
					if(user.getBooksToTrade().contains(b)) {
						bt.setUser2(u.getKey());
						bt.setBook1(b);
						bt.setBook2(u.getValue().get(0));
						
						return bt;
					}
				}
			}
		}
		
		return null;
	}
}
