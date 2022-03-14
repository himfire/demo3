package com.example.demo3.persistances.model.classroom;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classroom {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    @Column(name="id")
    private Long id;

    @Column(length = 500)
    @NotBlank(message = "Title must be empty")
    @NotNull(message = "Title must be null")
    @Size(min=6,max = 500,message = "Please add title correctly")
    private String title;

    @ManyToMany(targetEntity = Level.class)
    @JoinTable(name = "level_skills",
            joinColumns = @JoinColumn(name = "level_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id")
    )
    private Set<Level> skillLevel;

    @Column(name="price")
    private float price;

    @ManyToMany(targetEntity = LessonGroup.class)
    @JoinTable(name = "lesson_group_classroom",
            joinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    )
    private List<LessonGroup> lessonGroup;
}
