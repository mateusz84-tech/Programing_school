package pl.matkoc.service;

import java.util.List;

public interface CrudManager<T,V> {

    T create(T type);
    T read(V value);
    void update(T type);
    void delete(V type);
    List<T> finaAll();
}
