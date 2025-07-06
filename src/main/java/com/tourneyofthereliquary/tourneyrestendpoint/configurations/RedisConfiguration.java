package com.tourneyofthereliquary.tourneyrestendpoint.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.redis.lettucemod.api.StatefulRedisModulesConnection;
import com.redis.lettucemod.api.reactive.RedisModulesReactiveCommands;
import com.redis.lettucemod.utils.ConnectionBuilder;
import com.tourneyofthereliquary.tourneyrestendpoint.codecs.RedisSerializedObjectCodec;

import io.lettuce.core.AbstractRedisClient;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.dynamic.codec.RedisCodecResolver;


@Configuration
public class RedisConfiguration {

    // @Autowired
    // StatefulRedisModulesConnection<String, Object> connection;

    // @Bean
    // public ReactiveRedisOperations<String, Object> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
    //     StringRedisSerializer keySerializer = new StringRedisSerializer();
    //     GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
    //     RedisSerializationContext.RedisSerializationContextBuilder<String, Object> builder = RedisSerializationContext.newSerializationContext(keySerializer);
    //     RedisSerializationContext<String, Object> context = builder.value(valueSerializer).build();
    //     return new ReactiveRedisTemplate<>(factory, context);
    // }

    
    private final AbstractRedisClient client;

    public RedisConfiguration(AbstractRedisClient client) {
        this.client = client;
    }

    @Bean
    public StatefulRedisModulesConnection<String, String> lettuceModConnection() {
        return ConnectionBuilder.client(client).connection();
    }

    // @Bean
    // public RedisModulesReactiveCommands<String, Object> redisModulesReactiveCommands(){
    //     return connection.reactive();
    // }
}
