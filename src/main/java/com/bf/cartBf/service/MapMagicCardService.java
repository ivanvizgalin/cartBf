package com.bf.cartBf.service;

import com.bf.cartBf.database.entity.MapMagic;
import com.bf.cartBf.database.repository.MapMagicRepository;
import com.bf.cartBf.database.repository.SettingCardsRepository;
import com.bf.cartBf.util.MethodSelection;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MapMagicCardService implements MapMagicService {

    private final MapMagicRepository mapMagicRepository;

    private List<MapMagic> mapMagicsNumberTwo;
    private List<MapMagic> mapMagicsNumberFour;
    private List<MapMagic> mapMagicsNumberFive;
    private List<MapMagic> mapMagicsNumberSix;

    private int countTwo;
    private int countFour;
    private int countFive;
    private int countSix;

    @Override
    public void init() {
        mapMagicsNumberTwo = mapMagicRepository.getAllByNumberCard(2);
        mapMagicsNumberFour = mapMagicRepository.getAllByNumberCard(4);
        mapMagicsNumberFive = mapMagicRepository.getAllByNumberCard(5);
        mapMagicsNumberSix = mapMagicRepository.getAllByNumberCard(6);
    }

    @Override
    public MapMagic getMapMagic(int numberCard, String settings) {
        MethodSelection methodSelection = MethodSelection.SEQUENCE;
        if (settings.equals("random")) {
            methodSelection = MethodSelection.RANDOM;
        }

        if (numberCard == 2) {
            MapMagic mapMagic = null;
            try {
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberTwo, countTwo);
            } catch (IndexOutOfBoundsException e) {
                countTwo = 0;
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberTwo, countTwo);
            }
            countTwo++;
            return mapMagic;
        } else if (numberCard == 4) {
            MapMagic mapMagic = null;
            try {
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberFour, countFour);
            } catch (IndexOutOfBoundsException e) {
                countFour = 0;
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberFour, countFour);
            }
            countFour++;
            return mapMagic;
        } else if (numberCard == 5) {
            MapMagic mapMagic = null;
            try {
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberFive, countFive);
            } catch (IndexOutOfBoundsException e) {
                countFive = 0;
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberFive, countFive);
            }
            countFive++;
            return mapMagic;
        } else {
            MapMagic mapMagic = null;
            try {
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberSix, countSix);
            } catch (IndexOutOfBoundsException e) {
                countSix = 0;
                mapMagic = sequenceMagicCard(methodSelection, mapMagicsNumberSix, countSix);
            }
            countSix++;
            return mapMagic;
        }
    }

    private MapMagic sequenceMagicCard(MethodSelection methodSelection, List<MapMagic> mapMagics, int countMain) {
        if (methodSelection.equals(MethodSelection.RANDOM)) {
            Random random = new Random();
            return mapMagics.get(random.nextInt(mapMagics.size()));
        } else {
            return mapMagics.get(countMain);
        }
    }

}
