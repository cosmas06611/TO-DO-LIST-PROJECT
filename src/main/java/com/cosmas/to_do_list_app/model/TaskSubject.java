package com.cosmas.to_do_list_app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class TaskSubject {

    @Id
    private int taskId;
    private String title;
    private String description;
    private String status;
    private String priority;

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date dueDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date updatedAt;
    private boolean isArchived;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    private Date completedAt;

}
