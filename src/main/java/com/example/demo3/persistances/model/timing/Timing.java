package com.example.demo3.persistances.model.timing;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Timing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2,max = 25,message = "Please add your name")
    private String name;

    @NotNull
    @NotBlank(message = "Start Date must not be empty")
    private Date startDate;

    @Column(length = 10)
    @NotNull
    @NotBlank(message = "Start Date must not be empty")
    private Date endDate;
}
