package com.example.emazonstock.infrastructure.out.jpa.adapter;

import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.emazonstock.infrastructure.out.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.out.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort{

    private final ICategoryRepository categoryRepository;

    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }

    @Override
    public Category getCategory(String name) {
        return categoryEntityMapper.toCategory(categoryRepository.findByName(name).
                orElse(null));
    }

    @Override
    public PageResult<Category> getPagedCategories(int page, int sizePage, String order) {
        Sort.Direction direction;
        try {
            direction = Sort.Direction.fromString(order);
        } catch (IllegalArgumentException e) {
            throw new ValueDoesNotExist(); // Maneja valores inválidos
        }
        Sort sort = Sort.by(direction, "name");
        Pageable pageable = PageRequest.of(page, sizePage, sort);
        Page<CategoryEntity> categoryEntityPage = categoryRepository.findAll(pageable);

        List<Category> categoryList = categoryEntityMapper.toCategoryList(categoryEntityPage.getContent());

        return new PageResult<>(
                categoryList,
                categoryEntityPage.getNumber(),
                categoryEntityPage.getTotalPages(),
                categoryEntityPage.getTotalElements(),
                categoryEntityPage.getSize(),
                sort.toString()
        );
    }

}
