package com.example.app.prueba.service;

import com.example.app.prueba.dto.ReminderDto;
import com.example.app.prueba.entity.Reminder;
import com.example.app.prueba.mapper.AppMapper;
import com.example.app.prueba.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public ReminderDto saveReminder(ReminderDto reminderDTO) {
        Reminder reminder = AppMapper.toReminder(reminderDTO);
        Reminder savedReminder = reminderRepository.save(reminder);
        return AppMapper.toReminderDTO(savedReminder);
    }

    public Optional<ReminderDto> getReminderById(Long id) {
        return reminderRepository.findById(id).map(AppMapper::toReminderDTO);
    }

    public List<ReminderDto> getAllReminders() {
        return reminderRepository.findAll().stream()
                .map(AppMapper::toReminderDTO)
                .collect(Collectors.toList());
    }

    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

    public Optional<ReminderDto> updateReminder(Long id, ReminderDto reminderDTO) {
        if (reminderRepository.existsById(id)) {
            Reminder reminder = AppMapper.toReminder(reminderDTO);
            reminder.setId(id);
            Reminder updatedReminder = reminderRepository.save(reminder);
            return Optional.of(AppMapper.toReminderDTO(updatedReminder));
        }
        return Optional.empty();
    }
}
