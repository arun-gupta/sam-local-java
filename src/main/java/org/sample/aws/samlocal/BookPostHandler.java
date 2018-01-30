package org.sample.aws.samlocal;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class BookPostHandler implements RequestHandler<Book, String> {
    public String handleRequest(Book book, Context context) {
        System.out.println("Adding book: " + book);
//        Book book = new Book("1", "Minecraft Modding with Forge", "1234", "29.99");
        DDBUtil.getMapper().save(book);

        return book.getName() + " saved!";
    }
}
