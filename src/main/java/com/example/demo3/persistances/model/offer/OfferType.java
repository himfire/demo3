package com.example.demo3.persistances.model.offer;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OfferType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @NotBlank(message = "Offer name must not be empty")
    private String name;

    @Column
    @NotNull
    @NotBlank(message = "Offer type must not be empty")
    private Long type;
}
