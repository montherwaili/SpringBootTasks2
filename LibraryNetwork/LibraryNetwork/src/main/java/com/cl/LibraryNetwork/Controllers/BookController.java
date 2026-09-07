package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Book;
import com.cl.LibraryNetwork.Services.BookService;
import com.cl.LibraryNetwork.dto.BookDTO;
import com.cl.LibraryNetwork.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping
    public BookDTO createBook(@RequestBody Book book) {
        return bookMapper.convertToDTO(bookService.save(book));
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookMapper.convertToDTO(bookService.findAll());
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookMapper.convertToDTO(bookService.findById(id));
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookMapper.convertToDTO(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}