package com.bf.cartBf.service;

import com.bf.cartBf.database.entity.MapMagic;

public interface MapMagicService {

    MapMagic getMapMagic(int numberCard, String settings);

    void init();

}
