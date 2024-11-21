package com.example.app.prueba.controller;

import com.example.app.prueba.dto.ActivityDto;
import com.example.app.prueba.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(@RequestBody ActivityDto activityDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(activityService.createActivity(activityDTO));
    }

    @GetMapping("/lead/{leadId}")
    public ResponseEntity<List<ActivityDto>> getActivitiesByLeadId(@PathVariable Long leadId, @PathVariable String leadId) {
        return ResponseEntity.ok((List<ActivityDto>) activityService.getActivitiesByLeadId(leadId));
    }
}
