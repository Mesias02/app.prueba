package com.example.app.prueba.service;

import com.example.app.prueba.dto.ActivityDto;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public ActivityDto createActivity(ActivityDto activityDTO) {
        Activity activity = new Activity();
        activity.setType(activityDTO.getType());
        activity.setDescription(activityDTO.getDescription());
        activity.setLeadId(activityDTO.getLeadId());
        activity.setTimestamp(activityDTO.getTimestamp());
        activity = activityRepository.save(activity);
        return mapToDTO(activity);
    }

    public List<ActivityDto> getActivitiesByLeadId(Long leadId) {
        return activityRepository.findByLeadId(leadId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private ActivityDto mapToDTO(Activity activity) {
        ActivityDto dto = new ActivityDto();
        dto.setId(activity.getId());
        dto.setType(activity.getType());
        dto.setDescription(activity.getDescription());
        dto.setLeadId(activity.getLeadId());
        dto.setTimestamp(activity.getTimestamp());
        return dto;
    }
}
