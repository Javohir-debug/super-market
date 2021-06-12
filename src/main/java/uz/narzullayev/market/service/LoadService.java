package uz.narzullayev.market.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoadService {
    @PersistenceContext
    private EntityManager entityManager;
    private final String FETCH_TYPE = "javax.persistence.fetchgraph";

    public <T> T lazy_to_eager(Class<T> respClass, String entityGraphStr, Integer id) {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph(entityGraphStr);
        Map<String, Object> properties = new HashMap<>();
        properties.put(FETCH_TYPE, entityGraph);
        return entityManager.find(respClass, id, properties);
    }
}
