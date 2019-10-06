package me.junrup.projects.index.adUnit;

import lombok.extern.slf4j.Slf4j;
import me.junrup.projects.index.IndexAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class AdUnitIndex implements IndexAware<Long, AdUnitObject> {

    private static Map<Long, AdUnitObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>();
    }

    @Override
    public AdUnitObject get(Long key) {
        return null;
    }

    @Override
    public void add(Long key, AdUnitObject value) {

    }

    @Override
    public void update(Long key, AdUnitObject value) {

    }

    @Override
    public void delete(Long key, AdUnitObject value) {

    }
}
