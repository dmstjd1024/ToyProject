package com.dmstjd1024.toyproject.module.zone;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Zone {

    @Id @GeneratedValue
    private Long id;

    private String province;

    private String address1;

    private String address2;

}
