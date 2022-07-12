package br.com.maurigvs.todorestdemo;

import br.com.maurigvs.todorestdemo.data.entities.ToDoItem;
import br.com.maurigvs.todorestdemo.data.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoResource {

    @Autowired
    private ToDoItemRepository repository;

    @GetMapping
    public ResponseEntity<?> getAllToDos(){
        List<ToDoItem> list = repository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveToDo(@RequestBody ToDoItem item){
        ToDoItem itemSaved = repository.save(item);
        return new ResponseEntity<>(itemSaved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updatedToDo(@RequestBody ToDoItem item){
        ToDoItem itemSaved = repository.save(item);
        return new ResponseEntity<>(itemSaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable String id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
