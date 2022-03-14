package com.example.demo3.persistances.model.offer;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column
    @NotNull
    @NotBlank(message = "Number must not empty")
    private Long count;

    @NotNull
    @Column(length = 10)
    @NotBlank(message = "Start Date must not empty")
    private Date startDate;

    @NotNull
    @Column(length = 10)
    @NotBlank(message = "End Date must not empty")
    private Date endDate;

    @ManyToMany(targetEntity = OfferType.class)
    @JoinTable(name = "offer_types",
            joinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id")
    )
    private Set<OfferType> offerType;

    @NotNull
    @NotBlank(message = "Status must not empty")
    private Long status;
}
