package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Author;
import com.cl.LibraryNetwork.Services.AuthorService;
import com.cl.LibraryNetwork.dto.AuthorDTO;
import com.cl.LibraryNetwork.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping
    public AuthorDTO createAuthor(@RequestBody Author author) {
        return authorMapper.convertToDTO(authorService.save(author));
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorMapper.convertToDTO(authorService.findAll());
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorMapper.convertToDTO(authorService.findById(id));
    }

    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return authorMapper.convertToDTO(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}