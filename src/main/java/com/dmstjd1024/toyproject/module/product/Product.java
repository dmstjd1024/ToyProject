package com.dmstjd1024.toyproject.module.product;

import com.dmstjd1024.toyproject.module.category.Category;
import lombok.*;

import javax.persistence.*;

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

    private String image;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String shortDescription;

    private String size;

    private int qtyStock;

}
