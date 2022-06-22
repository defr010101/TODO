package com.defr010110.firstwebapplication.repository;

import com.defr010110.firstwebapplication.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
