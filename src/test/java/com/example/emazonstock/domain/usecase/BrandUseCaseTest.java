package com.example.emazonstock.domain.usecase;

import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;
import com.example.emazonstock.domain.model.Brand;
import com.example.emazonstock.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrandUseCaseTest {

    @Mock
    IBrandPersistencePort brandPersistencePort;

    @InjectMocks
    BrandUseCase brandUseCase;

    @Test
    void saveBrandTest() {
        //GIVEN
        Brand brand = new Brand(1L,"CategoryName","CategoryDescription");
        //WHEN
        brandUseCase.saveBrand(brand);
        //THEN
        verify(brandPersistencePort, times(1)).saveBrand(brand);
    }

    @Test
    void saveBrandTestWhenBrandDoesNotExist() {
        //GIVEN
        Brand brand = new Brand(1L,"CategoryName","CategoryDescription");
        //WHEN
        when(brandPersistencePort.getBrand(brand.getName().trim())).thenReturn(null);
        brandUseCase.saveBrand(brand);
        //THEN
        verify(brandPersistencePort, times(1)).saveBrand(brand);

    }

    @Test
    void SaveBrandWhenBrandAlreadyExistsTest() {
        // GIVEN
        Brand brand = new Brand(1L, "CategoryName", "CategoryDescription");

        //WHEN
        when(brandPersistencePort.getBrand(brand.getName().trim())).thenReturn(brand);
        assertThrows(AlreadyDeclaredValueException.class, () -> {
            brandUseCase.saveBrand(brand);
        });

        //THEN
        verify(brandPersistencePort, never()).saveBrand(any(Brand.class));
    }

    @Test
    void getCategoryTest() {
        // GIVEN
        String categoryName = "ExistingCategory";
        Brand expectedBrand = new Brand(1L, categoryName, "Description");
        given(brandPersistencePort.getBrand(categoryName)).willReturn(expectedBrand);

        // WHEN
        Brand result = brandUseCase.getBrand(categoryName);

        // THEN
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(expectedBrand.getName());
        assertThat(result.getDescription()).isEqualTo(expectedBrand.getDescription());
    }

    @Test
    void getCategoryWhenCategoryDoesNotExistTest() {
        // GIVEN
        String categoryName = "NonExistingCategory";
        given(brandPersistencePort.getBrand(categoryName)).willReturn(null);

        // WHEN / THEN
        assertThrows(ValueDoesNotExist.class, () -> {
            brandUseCase.getBrand(categoryName);
        });

        verify(brandPersistencePort,  times(1)).getBrand(Mockito.any(String.class));
    }
}