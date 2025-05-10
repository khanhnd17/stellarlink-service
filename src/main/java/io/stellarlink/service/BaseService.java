package io.stellarlink.service;

import java.util.Optional;

public interface BaseService<T, ID> {

  T create(T entity);

  Optional<T> getById(ID id);

  T update(ID id, T updatedEntity);

  void delete(ID id);
}