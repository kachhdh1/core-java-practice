import java.util.ArrayList;
import java.util.List;

public class BookCollection {
	
	private List<Book> books;
	
	public List<Book> findBooks(/*someFunctionalInterface searchCriteria*/) {
		List<Book> results = new ArrayList<Book>();
		
		for (Book nextBook : books) {
			/*if (searchCriteria.execute(nextBook)) {
				results.add(nextBook);
			}*/
		}
		
		return results;
	}
	
	public BookCollection() {
		 books = new ArrayList<Book>();
		 books.add(new Book(1,"Don Quixote","Miguel De Cervantes"));
		 books.add(new Book(2,"Pilgrim's Progress","John Bunyan"));
		 books.add(new Book(3,"Robinson Crusoe","Daniel Defoe"));
		 books.add(new Book(4,"Gulliver's Travels","Jonathan Swift"));
		 books.add(new Book(5,"Tom Jones","Henry Fielding"));
		 books.add(new Book(6,"Clarissa","Samuel Richardson"));
		 books.add(new Book(7,"Dangerous Liaisons","Pierre Choderlos De Laclos"));
		 books.add(new Book(8,"Emma","Jane Austen"));
		 books.add(new Book(9,"Frankenstein","Mary Shelley"));
		 books.add(new Book(10,"The Count of Monte Christo","Alexandre Dumas"));
		 books.add(new Book(11,"David Copperfield","Charles Dickens"));
		 books.add(new Book(12,"Wuthering Heights","Emily Bronte"));
		 books.add(new Book(13,"Jane Eyre","Charlotte Bronte "));
		 books.add(new Book(14,"Moby-Dick","Herman Melville"));
		 books.add(new Book(15,"Alice's Adventures In Wonderland","Lewis Carroll"));
		 books.add(new Book(16,"Little Women","Louisa M. Alcott"));
		 books.add(new Book(17,"Anna Karenina","Leo Tolstoy"));
		 books.add(new Book(18,"The Brothers Karamazov","Fyodor Dostoevsky"));
		 books.add(new Book(19,"Daniel Deronda","George Eliot"));
		 books.add(new Book(20,"Huckleberry Finn","Mark Twain"));
		 books.add(new Book(21,"Dr Jekyll and Mr Hyde","Robert Louis Stevenson"));
		 books.add(new Book(22,"Three Men in a Boat","Jerome K. Jerome"));
		 books.add(new Book(23,"The Picture of Dorian Gray","Oscar Wilde"));
		 books.add(new Book(24,"The Wind in the Willows","Kenneth Grahame "));
		 books.add(new Book(25,"A la Recherche du Temps Perdu ","Marcel Proust"));
		 books.add(new Book(26,"The Rainbow","D. H. Lawrence"));
		 books.add(new Book(27,"Ulysses","James Joyce"));
		 books.add(new Book(28,"Men Without Women","Ernest Hemingway"));
		 books.add(new Book(29,"The Trial","Franz Kafka"));
		 books.add(new Book(30,"To Kill A Mockingbird","Harper Lee"));
	}

}
	