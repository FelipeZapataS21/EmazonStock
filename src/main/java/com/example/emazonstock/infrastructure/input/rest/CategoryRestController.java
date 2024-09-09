package com.example.emazonstock.infrastructure.input.rest;

import com.example.emazonstock.application.dto.request.CategoriesRequest;
import com.example.emazonstock.application.dto.response.CategoriesResponse;
import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.application.handlers.categoryhandler.ICategoryHandler;
import com.example.emazonstock.domain.model.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryRestController{

    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<String> saveCategoryInCategories(@Valid @RequestBody CategoriesRequest categoriesRequest) {
        categoryHandler.saveCategoryInCategories(categoriesRequest);
        return new ResponseEntity<>("Category has been created succesfully!!", HttpStatus.CREATED);
    }

    @Operation(summary = "Get all the categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CategoriesResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<PageResultResponse<Category>> getAllCategoriesInCategories(
            @Valid @ModelAttribute PageResultRequest pageResultRequest
    ){
        return ResponseEntity.ok(categoryHandler.createPageableResponseForCategory(pageResultRequest));
    }

    @Operation(summary = "Get a category by their name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "category found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriesResponse.class))),
            @ApiResponse(responseCode = "404", description = "Category not found", content = @Content)
    })
    @GetMapping("/{name}")
    public ResponseEntity<CategoriesResponse> getCategoryFromCategories(
            @Parameter(description = "Name of the category to be returned")
            @PathVariable(name = "name") String name) {
        return ResponseEntity.ok(categoryHandler.getCategoryFromCategories(name.trim()));
    }
}

