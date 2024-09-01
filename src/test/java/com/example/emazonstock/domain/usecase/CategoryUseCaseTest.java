package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.DataProvider;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCategories() {
        List<Category> categoryList = DataProvider.categoryListMock();
        when(categoryPersistencePort.getAllCategories()).thenReturn(categoryList);

        // When
        List<Category> categoryListResult = categoryPersistencePort.getAllCategories();

        // Then
        System.out.println(categoryListResult);
        assertEquals(3, categoryList.size());
        assertEquals(3, categoryListResult.size());
        verify(categoryPersistencePort, times(1)).getAllCategories(); // Verifica que el mock fue llamado exactamente una vez

    }
}
