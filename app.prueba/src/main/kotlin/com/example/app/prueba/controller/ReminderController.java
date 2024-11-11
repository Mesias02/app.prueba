package com.example.app.prueba.controller;

import com.example.app.prueba.dto.ReminderDto;
import com.example.app.prueba.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseEntity<ReminderDto> createReminder(@RequestBody ReminderDto reminderDTO) {
        ReminderDto savedReminder = reminderService.saveReminder(reminderDTO);
        return ResponseEntity.status(201).body(savedReminder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReminderDto> getReminder(@PathVariable Long id) {
        Optional<ReminderDto> reminder = reminderService.getReminderById(id);
        return reminder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ReminderDto>> getAllReminders() {
        List<ReminderDto> reminders = reminderService.getAllReminders();
        return ResponseEntity.ok(reminders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReminderDto> updateReminder(@PathVariable Long id, @RequestBody ReminderDto reminderDTO) {
        Optional<ReminderDto> updatedReminder = reminderService.updateReminder(id, reminderDTO);
        return updatedReminder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
