package com.jotace.api.emailservice.infra.ses.configurations;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SesConfiguration {
    @Value("${aws.accessKeyId}")
    String accessKey;

    @Value("${aws.secretKey}")
    String secretKey;
    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
       return AmazonSimpleEmailServiceClientBuilder.standard()
               .withRegion(Regions.US_EAST_1)
               .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
