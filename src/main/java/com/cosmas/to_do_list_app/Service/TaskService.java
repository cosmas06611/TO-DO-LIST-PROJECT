package com.cosmas.to_do_list_app.Service;

import com.cosmas.to_do_list_app.Repository.TaskRepository;
import com.cosmas.to_do_list_app.model.TaskSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskSubject> getAllTask() {
        return taskRepository.findAll();
    }

    public TaskSubject getTaskById(int taskId) {
        TaskSubject ts =  taskRepository.findById(taskId).get();
        return ts;
        }


    public TaskSubject addNewTask(TaskSubject subject) {
        taskRepository.save(subject);
        return subject;
    }

    public TaskSubject updateTask(TaskSubject taskSubject) {
       return taskRepository.save(taskSubject);

    }

    public void deleteTask(int taskId) {

          taskRepository.deleteById(taskId);
    }
}
