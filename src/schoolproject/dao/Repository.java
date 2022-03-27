package schoolproject.dao;



import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.identifiiables.Identifiable;

import java.util.Collection;

public interface Repository<K,S,V extends Identifiable<K,S>> {

    public interface IdGenerator<K>{
        K getNextId();
    }

    public class LongIdGenerator implements IdGenerator<Long>
    { private long lastId=0;
        @Override
        public Long getNextId() {
            return ++lastId;
        }
    }
    Collection<V> findAll();
    V findById(K id);
    V add(V entity);
    V update(V entity) throws EntityNotFoundException;
    V delete(V entity) throws EntityNotFoundException;

}
