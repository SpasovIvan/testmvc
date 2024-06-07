package com.spasov.testmvc.service;

import com.spasov.testmvc.dao.CategoryRepository;
import com.spasov.testmvc.entity.Category;
import com.spasov.testmvc.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }
}
