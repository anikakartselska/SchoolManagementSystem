package schoolproject.dao.identifiiables;



public interface Identifiable <K,S>{
    K getId();
    void setId(Long id);
    S getName();
}
