package com.example.alexander.projectx.Controlador;

import java.util.List;

public interface INFPrincipal<T> {
    void Add(T obj);
    void Update(T obj);
    void Delete(Object cod);
    List<T> getList(Object f);
    T getItem(int f);
}
