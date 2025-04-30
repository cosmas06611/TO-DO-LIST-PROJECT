package com.cosmas.to_do_list_app.Controller;

import com.cosmas.to_do_list_app.Service.TaskService;
import com.cosmas.to_do_list_app.model.TaskSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskSubject>> getAllTask(){
      List  <TaskSubject> allTask = taskService.getAllTask();
        if(allTask != null){
            return
       new ResponseEntity<>( allTask,  HttpStatus.FOUND);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity <TaskSubject> getTaskById(@PathVariable int taskId){
        TaskSubject taskSubject = taskService.getTaskById(taskId);
        if(taskSubject !=null){
            return new ResponseEntity<>(taskSubject, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/task")
    public ResponseEntity <?> addNewTask(@RequestBody TaskSubject subject){
        TaskSubject subject1=  taskService.addNewTask(subject);
      return  (subject1 != null) ?
                    new ResponseEntity<>(subject1, HttpStatus.CREATED) :
                    new ResponseEntity<>("task was not created", HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/task")
    public ResponseEntity <TaskSubject> updateTask(@RequestBody TaskSubject taskSubject){
        TaskSubject taskSub = taskService.updateTask(taskSubject);
        return(taskSub != null) ?
                new ResponseEntity<>(taskSub, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DeleteMapping("task/{taskId}")
    public void deleteTask(@PathVariable int taskId){
       taskService.deleteTask(taskId);
    }

}
