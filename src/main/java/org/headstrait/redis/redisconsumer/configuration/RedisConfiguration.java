package org.headstrait.redis.redisconsumer.configuration;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisHashCommands;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {

    @Bean(destroyMethod = "close")
    public StatefulRedisConnection<String, String> redisClient(){
        //RedisClient redisClient = RedisClient.create("redis://localhost:6379");
        RedisClient redisClient = RedisClient.create("redis://Rd45svo02i@35.194.167.12:6379");
        return  redisClient.connect();
    }

    @Bean
    public RedisHashCommands<String, String> redisHashCommandsCommands(StatefulRedisConnection<String, String> connection) {
        return connection.sync();
    }
}
