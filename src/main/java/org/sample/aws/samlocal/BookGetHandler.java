package org.sample.aws.samlocal;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class BookGetHandler implements RequestHandler<String, Book> {

    public Book handleRequest(String key, Context context) {
        System.out.println("Key: " + key);
        return DDBUtil.getMapper().load(Book.class, key);
    }
}
