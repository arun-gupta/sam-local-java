package org.sample.aws.samlocal;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * @author arungupta
 */
public class DDBUtil {

	private static AmazonDynamoDB dynamodbClient;
	
	public static AmazonDynamoDB getClient() {
		if (null != dynamodbClient)
			return dynamodbClient;
		
		String region = System.getProperty("DYNAMODB_REGION");
		if (null == region) {
			System.err.println("Region not set, default \"" + Regions.US_WEST_1.name() + "\" is used");
			region = Regions.US_WEST_1.name();
		}
		System.out.println("DynamoDB region: " + region);
		
		dynamodbClient = AmazonDynamoDBClientBuilder.standard()
	            .withRegion(region)
	            .build();
		
		return dynamodbClient;
	}
}
