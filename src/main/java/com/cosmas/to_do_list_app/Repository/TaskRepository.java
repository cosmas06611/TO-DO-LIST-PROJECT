package com.cosmas.to_do_list_app.Repository;

import com.cosmas.to_do_list_app.model.TaskSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskSubject, Integer> {
}
