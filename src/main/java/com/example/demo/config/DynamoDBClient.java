package com.example.demo.config;

import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBClient {
    Logger logger = LoggerFactory.getLogger(DynamoDBClient.class);

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

    return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(
                    new BasicAWSCredentials("local", "local")))
            .withEndpointConfiguration(
                    new AwsClientBuilder.EndpointConfiguration(
                            "http://dynamodb:8000", ""))
            .build();
    }
}
