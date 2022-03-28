package schoolproject.dao.impl.helperrepositories;



import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.Repository;
import schoolproject.dao.exceptions.EntityNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl<K,S,V extends Identifiable<K,S>> implements Repository<K,S,V> {

    private final Map<K, V> entities = new HashMap<>();
    private final IdGenerator<Long> idGenerator= new LongIdGenerator();


    @Override
    public V delete(V entity) throws EntityNotFoundException {
        V old = entities.remove(entity.getId());
        if(old == null) {
            throw new EntityNotFoundException( " " + entity.getName() + "' does not exist.");
        }
        return old;
    }

    @Override
    public Collection<V> findAll() {
        return entities.values();
    }

    @Override
    public V findById(K id) {
        return entities.get(id);
    }

    @Override
    public V update(V entity) throws EntityNotFoundException{
        V old = findById(entity.getId());
        if(old == null) {
            throw new EntityNotFoundException("Entity'" + entity.getName() + "' does not exist.");
        }
        entities.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public V add(V entity) {
        entity.setId(idGenerator.getNextId());
        entities.put(entity.getId(), entity);
        return entity;
    }
}
