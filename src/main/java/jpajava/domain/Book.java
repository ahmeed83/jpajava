package jpajava.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Book {
	private String isbn;
	private String name;
	private Publisher publisher;
	private List<Chapter> chapters;

	public Book(final String isbn, final String name, final Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}
}












































