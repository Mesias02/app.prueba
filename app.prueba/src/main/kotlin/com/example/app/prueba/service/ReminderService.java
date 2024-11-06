package com.example.app.prueba.service;

import com.example.app.prueba.entity.Reminder;
import com.example.app.prueba.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sun.beans.introspect.PropertyInfo.Name.description;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    // Crear o actualizar un Recordatorio
    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    // Obtener un Recordatorio por ID
    public Optional<Reminder> getReminderById(Long id) {
        return reminderRepository.findById(id);
    }

    // Obtener todos los Recordatorios
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    // Eliminar un Recordatorio
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

    // Actualizar un Recordatorio
    public Optional<Reminder> updateReminder(Long id, Reminder reminder) {
        if (reminderRepository.existsById(id)) {
            reminder.setId(id);
            return Optional.of(reminderRepository.save(reminder));
        }
        return Optional.empty();
    }

    // Buscar Recordatorio por título
    public List<Reminder> searchRemindersByTitle(String title) {
        if (title != null) {
            return reminderRepository.findByDescriptionContainingIgnoreCase(String.valueOf(description));
        }
        return reminderRepository.findAll();
    }
}
