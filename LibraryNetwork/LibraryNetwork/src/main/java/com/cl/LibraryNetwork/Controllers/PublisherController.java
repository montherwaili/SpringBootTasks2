package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Publisher;
import com.cl.LibraryNetwork.Services.PublisherService;
import com.cl.LibraryNetwork.dto.PublisherDTO;
import com.cl.LibraryNetwork.mapper.PublisherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    @PostMapping
    public PublisherDTO createPublisher(@RequestBody Publisher publisher) {
        return publisherMapper.convertToDTO(publisherService.save(publisher));
    }

    @GetMapping
    public List<PublisherDTO> getAllPublishers() {
        return publisherMapper.convertToDTO(publisherService.findAll());
    }

    @GetMapping("/{id}")
    public PublisherDTO getPublisherById(@PathVariable Long id) {
        return publisherMapper.convertToDTO(publisherService.findById(id));
    }

    @PutMapping("/{id}")
    public PublisherDTO updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisher.setId(id);
        return publisherMapper.convertToDTO(publisherService.save(publisher));
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deleteById(id);
    }
}