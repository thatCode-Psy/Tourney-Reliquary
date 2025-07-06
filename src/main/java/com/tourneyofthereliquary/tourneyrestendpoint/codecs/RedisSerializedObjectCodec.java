package com.tourneyofthereliquary.tourneyrestendpoint.codecs;

import java.nio.ByteBuffer;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import io.lettuce.core.codec.RedisCodec;

public class RedisSerializedObjectCodec implements RedisCodec<String, Object>{

    GenericJackson2JsonRedisSerializer serializer;

    public RedisSerializedObjectCodec(){
        serializer = new GenericJackson2JsonRedisSerializer();
    }

    @Override
    public String decodeKey(ByteBuffer bytes) {
        try{
            byte[] array = new byte[bytes.remaining()];
            bytes.get(array);
            return serializer.deserialize(array, String.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object decodeValue(ByteBuffer bytes) {
        try{
            byte[] array = new byte[bytes.remaining()];
            bytes.get(array);
            return serializer.deserialize(array);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ByteBuffer encodeKey(String key) {
        return ByteBuffer.wrap(serializer.serialize(key));
    }

    @Override
    public ByteBuffer encodeValue(Object value) {
        return ByteBuffer.wrap(serializer.serialize(value));
    }
    
}
