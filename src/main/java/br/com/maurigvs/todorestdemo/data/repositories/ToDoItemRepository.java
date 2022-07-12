package br.com.maurigvs.todorestdemo.data.repositories;

import br.com.maurigvs.todorestdemo.data.entities.ToDoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoItemRepository extends MongoRepository<ToDoItem, String> {
}
