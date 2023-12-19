package com.iablonski.backend.planner.controller;

import com.iablonski.backend.planner.dto.PriorityDTO;
import com.iablonski.backend.planner.entity.Priority;
import com.iablonski.backend.planner.search.PrioritySearchValues;
import com.iablonski.backend.planner.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/priority")
public class PriorityController {

    private final PriorityService priorityService;

    @Autowired
    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @PostMapping("/id")
    public ResponseEntity<Priority> getPriorityById(@RequestBody Long id){
        return new ResponseEntity<>(priorityService.getPriorityById(id), HttpStatus.OK);
    }

    @PostMapping("/all")
    public List<Priority> getPrioritiesByUserEmail(@RequestBody String email){
        return priorityService.getPrioritiesByUserEmail(email);
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> addPriority(@RequestBody PriorityDTO priorityDTO){
        return new ResponseEntity<>(priorityService.addPriority(priorityDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> updatePriority(@RequestBody PriorityDTO priorityDTO){
        priorityService.updatePriority(priorityDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Priority> deletePriority (@PathVariable("id") Long id){
        priorityService.deletePriorityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Priority>> searchPriority(@RequestBody PrioritySearchValues values){
        List<Priority> priorityList = priorityService.findByTitle(values.getTitle(), values.getEmail());
        return new ResponseEntity<>(priorityList, HttpStatus.OK);
    }
}