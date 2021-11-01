package org.headstrait.redis.redisconsumer.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisHashCommands;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.headstrait.redis.redisconsumer.entity.EnergyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisService {

    @Autowired
    StatefulRedisConnection<String , String> connection;
    @Autowired
    RedisHashCommands<String, String> commands ;
    long current= System.currentTimeMillis();
    @Value("${redis-key}")
    String redis_key;

    public void processConsumerEvent(ConsumerRecord<Long, EnergyData> consumerRecord) {
        EnergyData consumerModel = consumerRecord.value();
        long key = consumerRecord.key();
        //System.out.println("key:== "+key);
        saveData(consumerModel, key);
    }

    public void saveData(EnergyData data, Long key) {
        long dateTimeKey = System.currentTimeMillis();
        log.info("Data Consumed : {}", commands.hset(redis_key,
                String.valueOf(key), data.toString()));
        log.info("Data count =" + String.valueOf(commands.hlen(redis_key)));
    }
}
