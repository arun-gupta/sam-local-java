package org.sample.aws.samlocal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class BookPostHandler implements RequestHandler<Book, String> {

    static DynamoDBMapper mapper = DDBUtil.getMapper();

    public String handleRequest(Book book, Context context) {
        System.out.println("Adding book: " + book);
        saveBook(book);

        return book.getName() + " saved!";
    }

    private void saveBook(Book book) {
        mapper.save(book);
    }
}
