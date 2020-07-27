package com.dmstjd1024.toyproject.module.account;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByNickname(String nickname);

    boolean existsByEmail(String nickname);

    boolean existsByNickname(String nickname);

    Account findByEmail(String email);

}
