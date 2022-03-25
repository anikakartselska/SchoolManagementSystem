package schoolproject.dao;



public interface Identifiable <K,S>{
    K getId();
    void setId(Long id);
    S getName();
}
