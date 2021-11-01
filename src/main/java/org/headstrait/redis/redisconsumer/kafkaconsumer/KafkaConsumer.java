package org.headstrait.redis.redisconsumer.kafkaconsumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.headstrait.redis.redisconsumer.entity.EnergyData;
import org.headstrait.redis.redisconsumer.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    RedisService service;

    @KafkaListener(topics = {"processed-transformer-data"})
    public void onMessage1(ConsumerRecord<Long, EnergyData> consumerRecord){
        service.processConsumerEvent(consumerRecord);
        log.info("ConsumerRecord-C1 : {} ", consumerRecord );

    }
}
