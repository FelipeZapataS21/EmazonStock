package com.example.emazonstock.infrastructure.out.jpa.adapter;

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

import static com.example.emazonstock.infrastructure.utils.jpaconstants.JpaAdapterConstants.PAGEABLE_BY_NAME;

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
        return categoryEntityMapper.toCategory(categoryRepository.findByName(name).orElse(null));
    }

    @Override
    public PageResult<Category> getPagedCategories(Integer currentPage, Integer sizePage, String orderSort) {
        Sort sort = Sort.by(Sort.Direction.fromString(orderSort), PAGEABLE_BY_NAME);
        Pageable pageable = PageRequest.of(currentPage, sizePage, sort);
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
