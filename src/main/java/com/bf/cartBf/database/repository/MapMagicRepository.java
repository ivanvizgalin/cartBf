package com.bf.cartBf.database.repository;

import com.bf.cartBf.database.entity.MapMagic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapMagicRepository extends CrudRepository<MapMagic, Long> {

    List<MapMagic> getAllByNumberCard(Integer numberCard);

}
