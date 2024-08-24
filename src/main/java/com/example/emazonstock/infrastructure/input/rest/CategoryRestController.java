package com.example.emazonstock.infrastructure.input.rest;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.application.handlers.categoryHandler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor

public class CategoryRestController {

    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })

    @PostMapping("/")
    public ResponseEntity<Void> saveCategoryInCategories(@RequestBody CategoriesRequest categoriesRequest) {
        categoryHandler.saveCategoryInCategories(categoriesRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriesResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<CategoriesResponse>> getAllCategoriesInCategories() {
        return ResponseEntity.ok(categoryHandler.getAllCategoriesFromCategories());
    }

    @Operation(summary = "Get a category by their name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "category found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriesResponse.class))),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
    })
    @GetMapping("/{number}")
    public ResponseEntity<CategoriesResponse> getCategoryFromCategories(@Parameter(description = "Name of the category to be returned")
                                                                 @PathVariable(name = "name") String name) {
        return ResponseEntity.ok(categoryHandler.getCategoryFromCategories(name));
    }

    @Operation(summary = "Update an existing category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
    })
    @PutMapping("/")
    public ResponseEntity<Void> updateCategoryFromCategories(@RequestBody CategoriesRequest categoriesRequest) {
        categoryHandler.updateCategoryFromCategories(categoriesRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete a category by their Name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Category deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
    })
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCategoryFromCategories(@PathVariable String name) {
        categoryHandler.deleteCategoryFromCategories(name);
        return ResponseEntity.noContent().build();
    }
}

