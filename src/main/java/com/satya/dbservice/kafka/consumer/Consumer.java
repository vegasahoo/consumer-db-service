package com.satya.dbservice.kafka.consumer;

import com.satya.dbservice.model.Product;
import com.satya.dbservice.repository.ProductRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    private ProductRepository productRepository;

    @KafkaListener(topics = "product_data",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, Product> record, Acknowledgment acknowledgment)
    {
        logger.info("key = "+ record.key());
        logger.info("message = " + record.value().toString());
        productRepository.save(record.value());
        acknowledgment.acknowledge();
    }
}
