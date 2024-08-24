package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.DataProvider;
import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.DescriptionRequiredException;
import com.example.emazonstock.domain.exceptions.MaximumLengthException;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test void testSaveCategoryAlreadyDeclaredValueException(){
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

    @Test
    public void testSaveCategoryMaximumLengthException(){
        //Given
        Category category = DataProvider.newCategoryMock(
                1L,
                "This is a very long name to test exception in category, is very cool!!",
                "this is a category"
        );

        // Then
        MaximumLengthException thrown = assertThrows(MaximumLengthException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        System.out.println("Exception message: " + thrown.getMessage());
    }

    @Test
    public void testSaveCategoryDescriptionRequiredException(){
        //Given
        Category category = DataProvider.newCategoryMock(2L, "NaugthyDogs","      ");

        //Then / Then
        DescriptionRequiredException thrown = assertThrows(DescriptionRequiredException.class, () -> {
            categoryUseCase.saveCategory(category);
        });

        System.out.println("Exception message: " + thrown.getMessage());
    }

    /*@Test
    public void testGetAllCategories(){
        //When
        when(categoryPersistencePort.getAllCategories()).thenReturn(DataProvider.categoryListMock());
        List<Category> categoryList = categoryUseCase.getAllCategories();

        //Then
        assertNotNull(categoryList);
        assertFalse(categoryList.isEmpty());
        assertEquals("Gamer Laptops", categoryList.get(0).getName());
        assertEquals("Computers Laptops Gamers for all", categoryList.get(0).getDescription());
    }*/

    /*@Test
    public void testGetCategory(){
        //When
        when(this.categoryPersistencePort.getCategory("Kitchenware"))
                .thenReturn(DataProvider.categoryMock());

        Category category = categoryPersistencePort.getCategory("Kitchenware");

        //Then
        assertNotNull(category);
        assertEquals("Kitchenware", category.getName());
        assertEquals("Tools and gadgets for your kitchen needs", category.getDescription());
        verify(this.categoryPersistencePort).getCategory("Kitchenware");
    }*/
}
