package com.example.demo3.persistances.model.classroom;

import com.example.demo3.persistances.model.resource.Resource;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lesson {

    @Id
    @GeneratedValue(
            strategy = IDENTITY
    )
    private Long id;

    @Column
    @NotNull
    @NotBlank(message = "Title must not be empty")
    @Size(min = 6, message = "Title must be at least 6 characters")
    private String title;

    @Column
    @NotNull
    @NotBlank(message = "Description must not be empty")
    @Size(min = 6, max = 20000,message = "Description must be at least 6 characters and maximum 20000")
    private String description;

    @Column
    @NotNull
    @NotBlank(message = "Content must not be empty")
    @Size(min = 6, max = 20000,message = "Content must be at least 6 characters and maximum 20000")
    private String content;

    @Column
    @NotNull
    @NotBlank(message = "URL must not be empty")
    @Size(min = 6, max = 2000,message = "URL must be at least 6 characters and maximum 2000")
    private String url;

    @Column
    @NotNull
    @NotBlank(message = "URL must not be empty")
    @Size(min = 6, max = 2000,message = "URL must be at least 6 characters and maximum 2000")
    private Long status;

    @ManyToMany(targetEntity = Resource.class)
    @JoinTable(name = "resource_lesson",
            joinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    )
    private List<Resource> resources;

}
