package com.example.emazonstock.infrastructure.input.rest;

import com.example.emazonstock.application.dto.request.BrandsRequest;
import com.example.emazonstock.application.dto.request.PageResultRequest;
import com.example.emazonstock.application.dto.response.BrandsResponse;
import com.example.emazonstock.application.dto.response.PageResultResponse;
import com.example.emazonstock.application.handlers.brandhandler.IBrandHandler;
import com.example.emazonstock.domain.model.Brand;
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
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandRestController {

    private final IBrandHandler brandHandler;

    @Operation(summary = "Add a new Brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Brand created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Brand already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<String> saveBrandInBrands(@Valid @RequestBody BrandsRequest brandsRequest) {
        brandHandler.saveBrandInBrands(brandsRequest);
        return new ResponseEntity<>("Brand has been created succesfully!!", HttpStatus.CREATED);
    }

    @Operation(summary = "Get all the brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All brands returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BrandsResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<PageResultResponse<Brand>> getAllBrandsInBrands(
            @Valid @ModelAttribute PageResultRequest pageResultRequest
    ){
        return ResponseEntity.ok(brandHandler.createPageableResponseForBrand(pageResultRequest));
    }

    @Operation(summary = "Get a Brand by their name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "brand found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BrandsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Brand not found", content = @Content)
    })
    @GetMapping("/{name}")
    public ResponseEntity<BrandsResponse> getBrandOfBrands(
            @Parameter(description = "Name of the brand to be returned")
            @PathVariable(name = "name") String name) {
        return ResponseEntity.ok(brandHandler.getBrandFromBrands(name.trim()));
    }

}
