package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;


    @Test
    void saveCategoryTest() {
        //GIVEN
        Category category = new Category(1L,"CategoryName","CategoryDescription");
        //WHEN
        categoryUseCase.saveCategory(category);
        //THEN
        verify(categoryPersistencePort, times(1)).saveCategory(category);

    }

    @Test
    void SaveCategoryWhenCategoryAlreadyExistsTest() {
        // GIVEN
        Category category = new Category(1L, "CategoryName", "CategoryDescription");

        //WHEN
        when(categoryPersistencePort.getCategory(category.getName().trim())).thenReturn(category);
        assertThrows(AlreadyDeclaredValueException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        //THEN
        verify(categoryPersistencePort, never()).saveCategory(any(Category.class));
    }

    /*@Test
    void getAllCategoriesTest() {
        // GIVEN
        List<Category> categoryList = List.of(
                new Category(1L, "Category1", "Description1"),
                new Category(2L, "Category2", "Description2"),
                new Category(3L, "Category3", "Description3")
        );

        // WHEN
        when(categoryPersistencePort.getAllCategories()).thenReturn(categoryList);
        List<Category> result = categoryUseCase.getAllCategories();

        // THEN
        assertThat(result)
                .isNotNull()
                .hasSize(3)
                .containsExactlyInAnyOrderElementsOf(categoryList);
        verify(categoryPersistencePort, times(1)).getAllCategories();
    }*/

    @Test
    void getCategoryTest() {
        // GIVEN
        String categoryName = "ExistingCategory";
        Category expectedCategory = new Category(1L, categoryName, "Description");
        given(categoryPersistencePort.getCategory(categoryName)).willReturn(expectedCategory);

        // WHEN
        Category result = categoryUseCase.getCategory(categoryName);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(expectedCategory.getName());
        assertThat(result.getDescription()).isEqualTo(expectedCategory.getDescription());
    }

    @Test
    void getCategoryWhenCategoryDoesNotExistTest() {
        // GIVEN
        String categoryName = "NonExistingCategory";
        given(categoryPersistencePort.getCategory(categoryName)).willReturn(null);

        // WHEN / THEN
        assertThrows(ValueDoesNotExist.class, () -> {
            categoryUseCase.getCategory(categoryName);
        });

        verify(categoryPersistencePort,  times(1)).getCategory(Mockito.any(String.class));
    }
}