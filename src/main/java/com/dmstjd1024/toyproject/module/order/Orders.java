package com.dmstjd1024.toyproject.module.order;

import com.dmstjd1024.toyproject.module.product.Product;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter @Setter

public class Orders {

    @Id @GeneratedValue
    private Long id;

    private Long accountId;

    private LocalDateTime orderTime;

    private int orderStock;

    @OneToMany
    private Set<Product> productSet = new HashSet<>();
}
