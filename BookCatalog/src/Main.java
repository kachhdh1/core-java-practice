import java.util.List;


public class Main {

	public static void main(String[] args) {

		BookCollection bc = new BookCollection();
		List<Book> foundBooks = bc.findBooks(/*someLambdaExpression*/);
	
		for (Book nextBook : foundBooks) {
			System.out.println (nextBook.getTitle() + " by " + nextBook.getAuthor());
		}
	}
}
