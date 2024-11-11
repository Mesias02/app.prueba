package com.example.app.prueba.mapper;

import com.example.app.prueba.dto.ReminderDto;
import com.example.app.prueba.dto.UserDto;
import com.example.app.prueba.entity.Reminder;
import com.example.app.prueba.entity.User;

public class AppMapper {

    // Mapping for Reminder
    public static ReminderDto toReminderDTO(Reminder reminder) {
        ReminderDto dto = new ReminderDto();
        dto.setId(reminder.getId());
        dto.setTitle(reminder.getTitle());
        dto.setDescription(reminder.getDescription());
        return dto;
    }

    public static Reminder toReminder(ReminderDto dto) {
        Reminder reminder = new Reminder();
        reminder.setId(dto.getId());
        reminder.setTitle(dto.getTitle());
        reminder.setDescription(dto.getDescription());
        return reminder;
    }

    // Mapping for User
    public static UserDto toUserDTO(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}
