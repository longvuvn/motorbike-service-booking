package com.example.motorbike_be.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination <T>{
    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    private List<T> content;

    public static <T, R> Pagination<R> of(Page<T> pageData, List<R> content) {
        Pagination<R> pagination = new Pagination<>();
        pagination.setContent(content);
        pagination.setPage(pageData.getNumber());
        pagination.setSize(pageData.getSize());
        pagination.setTotalElements(pageData.getTotalElements());
        pagination.setTotalPages(pageData.getTotalPages());
        return pagination;
    }
}
