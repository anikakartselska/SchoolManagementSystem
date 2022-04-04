package schoolproject.dao;

public interface IdGeneratorFactory<K> {
   IdGenerator<K> createIdGenerator(Class<K> idClass);
}
