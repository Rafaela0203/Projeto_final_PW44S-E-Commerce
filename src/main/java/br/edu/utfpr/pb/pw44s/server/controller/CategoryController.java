package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.response.ResponseCategoryDTO;
import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryService;
import br.edu.utfpr.pb.pw44s.server.service.IReadService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController extends ReadController<Category, ResponseCategoryDTO, Long> {
    private static ICategoryService categoryService;
    private static ModelMapper modelMapper;

    public CategoryController(ICategoryService categoryService,
                              ModelMapper modelMapper) {
        super(Category.class, ResponseCategoryDTO.class);
        CategoryController.categoryService = categoryService;
        CategoryController.modelMapper = modelMapper;
    }

    @Override
    protected IReadService<Category, Long> getService() {
        return CategoryController.categoryService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return CategoryController.modelMapper;
    }
}