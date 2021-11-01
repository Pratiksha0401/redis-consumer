package org.headstrait.redis.redisconsumer.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.headstrait.redis.redisconsumer.entity.EnergyData;

import java.io.IOException;
import java.util.Map;


public class CustomDeserializer implements Deserializer<EnergyData> {

    ObjectMapper objectMapper;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public EnergyData deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, EnergyData.class);
        } catch (final IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
