package com.zhangbin.learncase.webflux;

import org.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangbin
 * @Type UserService
 * @Desc
 * @date 2018-05-29
 * @Version V1.0
 */
@Service
public class UserService {
    private final static Map<String, User> data = new HashMap<>();

    static {
        data.put("1", new User("1", "abc", "abc@xxxx.com"));
    }


    Flux<User> list() {
        return Flux.fromIterable(this.data.values());
    }

    Flux<User> getById(final Flux<User> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    Mono<User> getById(final String id) {
        System.out.println("id = " + id);
        return Mono.justOrEmpty(this.data.get(id)).switchIfEmpty(Mono.error(new ResourceNotFoundException("不存在")));
    }

    Flux<User> createOrUpdate(final Flux<User> users) {
        return users.doOnNext(user -> this.data.put(user.getId(), user));
    }

    Mono<User> createOrUpdate(final User user) {
        this.data.put(user.getId(), user);
        return Mono.just(user);
    }

    Mono<User> delete(final String id) {
        return Mono.justOrEmpty(this.data.remove(id));
    }

}
