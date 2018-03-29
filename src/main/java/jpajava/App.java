package jpajava;

import jpajava.client.BookStoreClient;
import jpajava.service.BookStoreService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        BookStoreService bookStoreService = new BookStoreService();

        //persisting object graph
        //BookStoreClient.saveToDatabase(bookStoreService);

        //retrieving object graph
        BookStoreClient.retrieveFromDatabase(bookStoreService);
    }
}
