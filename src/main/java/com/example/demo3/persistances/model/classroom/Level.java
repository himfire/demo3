package com.example.demo3.persistances.model.classroom;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    @Size(min = 1, max =10,message = "Level Code is exceeding 10")
    @NotNull
    @NotBlank(message = "code must not be empty")
    private String code;

    @Column(length = 100)
    @Size(min = 1, max =100,message = "Level name Code is exceeding 100")
    @NotNull
    @NotBlank(message = "Level name must not be empty")
    private String name;
}
