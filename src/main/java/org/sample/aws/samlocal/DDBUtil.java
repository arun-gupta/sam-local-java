package org.sample.aws.samlocal;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

/**
 * @author arungupta
 */
public class DDBUtil {

	private static AmazonDynamoDB dynamodbClient;
	private static DynamoDBMapper mapper;

	public static DynamoDBMapper getMapper() {
		if (null != mapper)
			return mapper;

		mapper = new DynamoDBMapper(DDBUtil.getClient(),
				new DynamoDBMapperConfig(new TableNameResolver()));
		return mapper;
	}

	public static AmazonDynamoDB getClient() {
		if (null != dynamodbClient)
			return dynamodbClient;
		
		String region = System.getenv("AWS_REGION");
		if (null == region) {
			System.err.println("Region not set, default \"" + Regions.US_EAST_1.name() + "\" is used");
			region = Regions.US_EAST_1.name();
		}
		System.out.println("DynamoDB region: " + region);
		
		dynamodbClient = AmazonDynamoDBClientBuilder.standard()
	            .withRegion(region)
	            .build();
		
		return dynamodbClient;
	}
}
