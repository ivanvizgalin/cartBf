package com.bf.cartBf.database.repository;

import com.bf.cartBf.database.entity.SettingCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingCardsRepository extends JpaRepository<SettingCards, Long> {

    SettingCards getSettingCardsById(Long idOne);

}
