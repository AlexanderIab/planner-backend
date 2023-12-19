package com.iablonski.backend.planner.controller;

import com.iablonski.backend.planner.entity.Stat;
import com.iablonski.backend.planner.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/stat")
public class StatController {

    private final StatService statService;

    @Autowired
    public StatController(StatService statService) {
        this.statService = statService;
    }

    @PostMapping("/search")
    public ResponseEntity<Stat> findStat(@RequestBody String email){
        Stat stat= statService.findStat(email);
        return new ResponseEntity<>(stat, HttpStatus.OK);
    }
}
