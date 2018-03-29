package jpajava.client;

import jpajava.domain.Book;
import jpajava.domain.Chapter;
import jpajava.domain.Publisher;
import jpajava.service.BookStoreService;

import java.util.ArrayList;
import java.util.List;

public class BookStoreClient {

	public static void saveToDatabase(final BookStoreService bookStoreService) {
		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");

		Book book = new Book("9781617290459", "Java Persistence with Hibernate, Second Edition", publisher);

		List<Chapter> chapters = new ArrayList<Chapter>();
		Chapter chapter1 = new Chapter(1, "Introducing JPA and Hibernate");
		chapters.add(chapter1);
		Chapter chapter2 = new Chapter(2, "Domain Models and Metadata");
		chapters.add(chapter2);

		book.setChapters(chapters);

		bookStoreService.persistObjectGraph(book);
	}

	public static void retrieveFromDatabase(final BookStoreService bookStoreService) {
		Book book = bookStoreService.retrieveObjectGraph("9781617290459");
		System.out.println(book);
	}
}





