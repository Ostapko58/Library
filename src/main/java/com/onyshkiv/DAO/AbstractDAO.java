package com.onyshkiv.DAO;

import com.onyshkiv.DAO.entity.Entity;

import java.util.List;

public interface AbstractDAO<K, T extends Entity> {
    List<T> findAll() throws DAOException;
    T findEntityById(K id) throws DAOException;
    boolean create(T model) throws DAOException;
    Entity read(K key) throws DAOException;
    T update(T model) throws DAOException;
    boolean delete(T model) throws DAOException;
}