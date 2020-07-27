package com.dmstjd1024.toyproject.module.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String productImage;

    private Long price;

    private String type;

    private String shortDescription;

    private String size;

    private int qtyStock;

    private LocalDateTime createdDate;

}
