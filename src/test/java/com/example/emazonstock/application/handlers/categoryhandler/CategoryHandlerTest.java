package com.example.emazonstock.application.handlers.categoryhandler;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.mappers.requestmappers.CategoriesRequestMapper;
import com.example.emazonstock.application.mappers.responsemappers.CategoriesResponseMapper;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryHandlerTest {

    @Mock
    private CategoriesRequestMapper categoriesRequestMapper;

    @Mock
    private ICategoryServicePort categoryServicePort;

    @Mock
    private CategoriesResponseMapper categoriesResponseMapper;

    @InjectMocks
    private CategoryHandler categoryHandler;

    @Test
    void saveCategoryInCategoriesTest(){
        //Given
        CategoriesRequest categoriesRequest = new CategoriesRequest(
                "Electronics", "All kinds of electronic items"
        );
        Category category = new Category(1L, "Electronics", "All kinds of electronic items");

        when(categoriesRequestMapper.toCategory(any(CategoriesRequest.class))).thenReturn(category);

        // When 
        categoryHandler.saveCategoryInCategories(categoriesRequest);

        // Then
        verify(categoriesRequestMapper, times(1)).toCategory(categoriesRequest);
        verify(categoryServicePort, times(1)).saveCategory(category);
    }


}
