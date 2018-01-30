package org.sample.aws.samlocal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class TableNameResolver extends DynamoDBMapperConfig.DefaultTableNameResolver {
    @Override
    public String getTableName(Class<?> clazz, DynamoDBMapperConfig config) {
        return System.getenv("TABLE_NAME");
    }
}
