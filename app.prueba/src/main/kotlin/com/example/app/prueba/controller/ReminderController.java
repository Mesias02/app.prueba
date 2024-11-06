package com.example.app.prueba.controller;

import com.example.app.prueba.entity.Reminder;
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

    // Crear un Recordatorio
    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder savedReminder = reminderService.saveReminder(reminder);
        return ResponseEntity.status(201).body(savedReminder);
    }

    // Obtener un Recordatorio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminder(@PathVariable Long id) {
        Optional<Reminder> reminder = reminderService.getReminderById(id);
        return reminder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los Recordatorios
    @GetMapping
    public ResponseEntity<List<Reminder>> getAllReminders() {
        List<Reminder> reminders = reminderService.getAllReminders();
        return ResponseEntity.ok(reminders);
    }

    // Eliminar un Recordatorio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un Recordatorio por ID
    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Optional<Reminder> updatedReminder = reminderService.updateReminder(id, reminder);
        return updatedReminder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar Recordatorio por Nombre o Título (opcional)
    @GetMapping("/search")
    public ResponseEntity<List<Reminder>> searchReminders(@RequestParam(required = false) String title) {
        List<Reminder> reminders = reminderService.searchRemindersByTitle(title);
        return ResponseEntity.ok(reminders);
    }
}

