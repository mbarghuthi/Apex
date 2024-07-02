package com.automation.state;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StateManager {

    private Map<String, Object> resourceMap;

    public StateManager() {
        resourceMap = new HashMap<>();
    }

    public void put(String key, Object object) {
        System.out.println("Putting value in StateManager: key=" + key + ", value=" + object);
        resourceMap.put(key, object);
    }

    public Object get(String key) {
        Object value = resourceMap.get(key);
        System.out.println("Getting value from StateManager: key=" + key + ", value=" + value);
        return value;
    }

    public void clear() {
        resourceMap.clear();
    }
}