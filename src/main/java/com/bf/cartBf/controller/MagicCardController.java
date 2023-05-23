package com.bf.cartBf.controller;

import com.bf.cartBf.database.entity.MapMagic;
import com.bf.cartBf.service.MapMagicService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/map-magic")
@AllArgsConstructor
public class MagicCardController {

    private final MapMagicService mapMagicService;

    @GetMapping(value = "/get-card")
    public ResponseEntity<MapMagic> getMapMagicCard(@RequestParam("numberCard") Integer numberCard, @RequestParam("settings") String settings) {
        try {
            return new ResponseEntity<>(mapMagicService.getMapMagic(numberCard, settings), HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> testController(){
        try {
            mapMagicService.init();
            return new ResponseEntity<>("Успешно", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ошибка инициализации карт", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
