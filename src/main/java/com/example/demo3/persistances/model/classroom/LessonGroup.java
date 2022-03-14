package com.example.demo3.persistances.model.classroom;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LessonGroup {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(length = 300)
    @NotBlank(message = "Title must be empty")
    @NotNull(message = "Title must be null")
    @Size(min=6,max = 300,message = "Please add title correctly")
    private String title;

    @Column(length = 800)
    @NotBlank(message = "Description must be empty")
    @NotNull(message = "Description must be null")
    @Size(min=6,max = 800,message = "Please add description correctly")
    private String description;

    @ManyToMany(targetEntity = Lesson.class)
    @JoinTable(name = "lesson_classroom",
            joinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    )
    private List<Lesson> lesson;
}
