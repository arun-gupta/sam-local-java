package org.sample.aws.samlocal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class BookGetHandler implements RequestHandler<String, Book> {

    static DynamoDBMapper mapper = DDBUtil.getMapper();

    public Book handleRequest(String key, Context context) {
        System.out.println("Key: " + key);
        return getBook(key);
    }

    private Book getBook(String key) {
        return mapper.load(Book.class, key);
    }
}
