package com.dmstjd1024.toyproject.module.order;

import com.dmstjd1024.toyproject.module.account.Account;
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
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    private LocalDateTime orderTime;

    private int orderStock;

    @OneToMany
    private Set<Product> productSet = new HashSet<>();

}
