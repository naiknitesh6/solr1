package com.example.DecRedisPractise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepo {
	public static final String HASH_KEY = "User";
    @Autowired
    private RedisTemplate template;

    public User save(User user){
        template.opsForHash().put(HASH_KEY,user.getId(),user);
        return user;
    }

    public List<User> findAll(){
    	System.out.println("Not called");
        return template.opsForHash().values(HASH_KEY);
    }
    public Object findById(int id){
        return  template.opsForHash().get(HASH_KEY,id);
    }
}

//(User)
