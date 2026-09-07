package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Category;
import com.cl.LibraryNetwork.Services.CategoryService;
import com.cl.LibraryNetwork.dto.CategoryDTO;
import com.cl.LibraryNetwork.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping
    public CategoryDTO createCategory(@RequestBody Category category) {
        return categoryMapper.convertToDTO(categoryService.save(category));
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.convertToDTO(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryMapper.convertToDTO(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryMapper.convertToDTO(categoryService.save(category));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}