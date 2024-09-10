package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.NotValidValuePageSort;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.model.PageResult;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.example.emazonstock.domain.utils.ExceptionsConstants.EXCEPTION_NOT_VALID_VALUE_PAGE_SORT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void saveCategoryTestWhenCategoryDoesNotExist() {
        //GIVEN
        Category category = new Category(1L,"CategoryName","CategoryDescription");
        //WHEN
        when(categoryPersistencePort.getCategory(category.getName().trim())).thenReturn(null);
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

    @Test
    void testGetPagedCategories_ValidSort() {
        // Arrange
        Integer currentPage = 1;
        Integer sizePage = 10;
        String validSort = "asc";

        List<Category> mockData = Arrays.asList(
                new Category(1L,"Category1", "Description category1"),
                new Category(2L,"Category2", "Description category2")
        );

        int totalPages = 5;
        long totalItems = 2;
        int pageSize = 10;
        String sort = "asc";

        PageResult<Category> mockResult = new PageResult<>(mockData, currentPage, totalPages, totalItems, pageSize, sort);


        when(categoryPersistencePort.getPagedCategories(currentPage, sizePage, validSort)).thenReturn(mockResult);

        // Act
        PageResult<Category> result = categoryUseCase.getPagedCategories(currentPage, sizePage, validSort);

        // Assert
        assertEquals(mockResult, result);
        verify(categoryPersistencePort, times(1)).getPagedCategories(currentPage, sizePage, validSort);
    }

    @Test
    void testGetPagedCategories_InvalidSort() {
        // Arrange
        Integer currentPage = 1;
        Integer sizePage = 10;
        String invalidSort = "invalid";

        // Act & Assert
        Exception exception = assertThrows(NotValidValuePageSort.class, () -> {
            categoryUseCase.getPagedCategories(currentPage, sizePage, invalidSort);
        });

        assertEquals(EXCEPTION_NOT_VALID_VALUE_PAGE_SORT, exception.getMessage());
        verify(categoryPersistencePort, never()).getPagedCategories(any(), any(), any());
    }
}