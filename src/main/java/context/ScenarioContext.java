package context;

import Constant.ContextKey;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<ContextKey, Object> contextMap =
            new HashMap<>();

    public void set(
            ContextKey key,
            Object value
    ) {

        contextMap.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(ContextKey key) {
        return (T) contextMap.get(key);
    }

    public boolean contains(ContextKey key) {

        return contextMap.containsKey(key);
    }

    public void remove(ContextKey key) {

        contextMap.remove(key);
    }

    public void clear() {

        contextMap.clear();
    }


}