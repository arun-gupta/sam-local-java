package org.sample.aws.samlocal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * @author arungupta
 */
public class BookGetHandler implements RequestHandler<String, Book> {

    public Book handleRequest(String key, Context context) {
        DynamoDBMapper mapper = new DynamoDBMapper(DDBUtil.getClient());
        return mapper.load(Book.class, key);
    }
}
