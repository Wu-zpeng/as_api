package com.example.as.api.service;

import com.example.as.api.entity.CategoryEntity;
import com.example.as.api.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryService {

    @Autowired
    private CategoryMapper mCategoryMapper;

    public List<CategoryEntity> getCategoryList(int pageIndex, int pageSize) {
        return mCategoryMapper.getCategoryList(pageIndex, pageSize);
    }
}
