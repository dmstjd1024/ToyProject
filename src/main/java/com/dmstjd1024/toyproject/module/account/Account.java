package com.dmstjd1024.toyproject.module.account;

import com.dmstjd1024.toyproject.module.order.Orders;
import lombok.*;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany
    private Set<Orders> orderList = new HashSet<>();
}
