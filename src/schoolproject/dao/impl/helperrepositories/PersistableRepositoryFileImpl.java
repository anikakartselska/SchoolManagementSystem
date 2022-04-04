package schoolproject.dao.impl.helperrepositories;
import schoolproject.dao.IdGenerator;
import schoolproject.dao.LongIdGenerator;
import schoolproject.dao.PersistableRepository;
import schoolproject.dao.identifiiables.Identifiable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class PersistableRepositoryFileImpl<K,S, V extends Identifiable<K,S>> extends RepositoryImpl<K,S,V> implements PersistableRepository<K,S,V> {
    private String dbFileName;

    public PersistableRepositoryFileImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator);
        this.dbFileName = dbFileName;
    }

    @Override
    public void load() {
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dbFileName)))) {
            clear();
            getIdGenerator().reset((Long) in.readObject());
            addAll((Collection<V>)in.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dbFileName)))) {
            out.writeObject(getIdGenerator().getCurrentId());
            out.writeObject(new ArrayList(findAll()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
