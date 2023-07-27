package com.satya.dbservice.kafka.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satya.dbservice.model.Product;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomDeserializer implements Deserializer<Product> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Product deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                logger.info("Null received at deserializing");
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), Product.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Product");
        }
    }
}
