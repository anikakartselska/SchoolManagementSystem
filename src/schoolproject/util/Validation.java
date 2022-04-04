package schoolproject.util;

import schoolproject.dao.exceptions.InvalidEntityDataException;

public interface Validation<V> {
    void validate(V entity) throws InvalidEntityDataException;
}
