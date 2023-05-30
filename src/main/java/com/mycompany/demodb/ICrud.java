package com.mycompany.demodb;

import java.util.*;

/*
 * @author Nwitlyck
 */
public interface ICrud<T>{
    
    public void insert(T object);
    public void update(T object);
    public void delete(T object);
    public List<T> select();
    public T getByPk(int pk);
    
}
