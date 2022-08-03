package sg.nus.iss.day17workshop.repositories;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class BoardGameRepository {
    
    @Value ("${boardgame.cache.duration}")
    private long cacheTime;

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    public void save(String count, String payload){
        ValueOperations<String, String>valueOp = redisTemplate.opsForValue();
        valueOp.set(count, payload, Duration.ofMinutes(cacheTime));

    }
    public Optional<String> get(String count){
        ValueOperations<String, String>valueOp = redisTemplate.opsForValue();
        String value = valueOp.get(count);
        if(null == value)
        return Optional.empty();
        return Optional.of(value);
    }
}
