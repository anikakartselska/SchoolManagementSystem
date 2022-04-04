package schoolproject.dao;

import schoolproject.dao.identifiiables.Identifiable;

public interface PersistableRepository<K,S, V extends Identifiable<K,S>> extends Repository<K,S,V>, Persistable {
}
