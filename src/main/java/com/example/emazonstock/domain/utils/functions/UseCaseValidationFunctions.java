package com.example.emazonstock.domain.utils.functions;

import com.example.emazonstock.domain.exceptions.AlreadyDeclaredValueException;
import com.example.emazonstock.domain.exceptions.NotValidValuePageSort;
import com.example.emazonstock.domain.exceptions.ValueDoesNotExist;

import java.util.Arrays;
import java.util.List;

import static com.example.emazonstock.domain.utils.Constants.ExceptionsConstants.*;
import static com.example.emazonstock.domain.utils.Constants.UseCaseCategoryConstants.VALUE_PAGE_SORT_ASC;
import static com.example.emazonstock.domain.utils.Constants.UseCaseCategoryConstants.VALUE_PAGE_SORT_DESC;

public class UseCaseValidationFunctions{

    private UseCaseValidationFunctions() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> void validateIfObjectExist(T object){
        if(object != null){
            throw new AlreadyDeclaredValueException(EXCEPTION_VALUE_ALREADY_EXIST);
        }
    }

    public static <T> void validateGetObject(T object){
        if(object == null){
            throw new ValueDoesNotExist(EXCEPTION_NO_VALUE_FOUND);
        }
    }

    public static void validateCorrectSort(String sortValue){
        List<String> validSortValues = Arrays.asList(VALUE_PAGE_SORT_ASC,VALUE_PAGE_SORT_DESC);
        if(!validSortValues.contains(sortValue.toLowerCase())){
            throw new NotValidValuePageSort(EXCEPTION_NOT_VALID_VALUE_PAGE_SORT);
        }
    }
}
