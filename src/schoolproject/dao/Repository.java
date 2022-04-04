package schoolproject.dao;



import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.identifiiables.Identifiable;

import java.util.Collection;

public interface Repository<K,S,V extends Identifiable<K,S>> {


    Collection<V> findAll();
    V findById(K id);
    V add(V entity);
    V update(V entity) throws EntityNotFoundException;
    V delete(V entity) throws EntityNotFoundException;
    void addAll(Collection<V> entities);
    void clear();

}
