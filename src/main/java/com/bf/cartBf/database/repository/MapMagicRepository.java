package com.bf.cartBf.database.repository;

import com.bf.cartBf.database.entity.MapMagic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MapMagicRepository extends JpaRepository<MapMagic, Long> {

    List<MapMagic> getAllByNumberCard(Integer numberCard);

}
