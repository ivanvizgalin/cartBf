package com.bf.cartBf.service;

import com.bf.cartBf.database.entity.MapMagic;
import org.springframework.stereotype.Service;

public interface MapMagicService {

    MapMagic getMapMagic(int numberCard, String settings);

    void init();

}
