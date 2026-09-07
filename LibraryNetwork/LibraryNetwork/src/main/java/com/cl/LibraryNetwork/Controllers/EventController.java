package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Event;
import com.cl.LibraryNetwork.Services.EventService;
import com.cl.LibraryNetwork.dto.EventDTO;
import com.cl.LibraryNetwork.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping
    public EventDTO createEvent(@RequestBody Event event) {
        return eventMapper.convertToDTO(eventService.save(event));
    }

    @GetMapping
    public List<EventDTO> getAllEvents() {
        return eventMapper.convertToDTO(eventService.findAll());
    }

    @GetMapping("/{id}")
    public EventDTO getEventById(@PathVariable Long id) {
        return eventMapper.convertToDTO(eventService.findById(id));
    }

    @PutMapping("/{id}")
    public EventDTO updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        return eventMapper.convertToDTO(eventService.save(event));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
    }
}