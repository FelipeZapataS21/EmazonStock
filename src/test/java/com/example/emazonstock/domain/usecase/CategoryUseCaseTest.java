package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.DataProvider;
import com.example.emazonstock.domain.exceptions.*;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test void testSaveCategoryAlreadyDeclaredValueException(){
        //Given
        Category category = DataProvider.newCategoryMock(1L,"Gamer Laptops","Good technology");

        //When
        when(categoryPersistencePort.getCategory(category.getName()))
                .thenReturn(category);

        // / Then
        AlreadyDeclaredValueException thrown = assertThrows(AlreadyDeclaredValueException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        System.out.println("Exception message: " + thrown.getMessage());

    }

}
