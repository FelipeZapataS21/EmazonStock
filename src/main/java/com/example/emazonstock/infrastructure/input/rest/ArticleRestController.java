package com.example.emazonstock.infrastructure.input.rest;

import com.example.emazonstock.application.dto.request.article.StringArticleRequest;
import com.example.emazonstock.application.handlers.articlehandler.IArticleHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleRestController {

    private final IArticleHandler articleHandler;

    @Operation(summary = "Add a new Article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Article created", content = @Content),
    })
    @PostMapping("/")
    public ResponseEntity<StringArticleRequest> saveArticleInArticles(@Valid @RequestBody StringArticleRequest stringArticleRequest) {
        articleHandler.saveArticleInArticles(stringArticleRequest);
        return new ResponseEntity<>(stringArticleRequest, HttpStatus.CREATED);
    }

}
