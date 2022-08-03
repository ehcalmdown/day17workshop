package sg.nus.iss.day17workshop.repositories;

// import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
// import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class BoardGameRepository {
    //to instantiate a set time to hold the cache or it will never leave
    @Value ("${boardgame.cache.duration}")
    private long cacheTime;

    @Autowired //please remember to do this or else the redisTemplate cannot work
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    // //create cache time limit to prevent overloading of cache
    // public void save(String count, String payload){
    //     ValueOperations<String, String>valueOp = redisTemplate.opsForValue();
    //     valueOp.set(count, payload, Duration.ofMinutes(cacheTime));

    // }
    // public String get(String count){
    //     ValueOperations<String, String>valueOp = redisTemplate.opsForValue();
    //     String value = valueOp.get(count);
    //     if(null == value)
    //     return Optional.empty();
    //     return Optional.of(value);
    // }

    //list the keys of the board games
    //count stand for the number used for the keys
    public Integer count(){
        Set<String> keys = redisTemplate.keys("[0-9]*");
        return keys.size();
    }
    public List<String> keys(){
        Set<String> keys = redisTemplate.keys("[0-9]*");
        List<String>result = new LinkedList<>(keys);
        return result.stream()
                .map(v -> Integer.parseInt(v)) //to convert the string obtained from keys into integer
                .sorted() //to sort the keys in sequence
                .map(v -> v.toString()) //convert it back to String to make it usable in context
                .toList(); //converts it to list
    }

    public String get(String gameId) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        return valueOps.get(gameId);
    }
}

