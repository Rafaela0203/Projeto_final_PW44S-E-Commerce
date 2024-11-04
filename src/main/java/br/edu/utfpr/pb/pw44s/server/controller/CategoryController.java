package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.CategoryDTO;
import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryService;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController extends CrudController<Category, CategoryDTO, Long> {
    private static ICategoryService categoryService;
    private static ModelMapper modelMapper;

    public CategoryController(ICategoryService categoryService,
                              ModelMapper modelMapper) {
        super(Category.class, CategoryDTO.class);
        CategoryController.categoryService = categoryService;
        CategoryController.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Category, Long> getService() {
        return CategoryController.categoryService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return CategoryController.modelMapper;
    }
}
//    private final ICategoryService categoryService;
//
//    public CategoryController(ICategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    /*
//
//
//     */
//
//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category) {
//        Category categoryCreated = categoryService.save(category);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}").buildAndExpand(category.getId()).toUri();
//
//        return ResponseEntity.created(location).body(categoryCreated);
//    }
//
//
//    //GET para http://locahost:8080/1
//    @GetMapping("{id}")
//    public ResponseEntity<Category> findOne(@PathVariable Long id) {
//        return ResponseEntity.ok(categoryService.findById(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Category>> findAll() {
//        return ResponseEntity.ok(categoryService.findAll());
//    }
//
//    @GetMapping("exists/{id}")
//    public ResponseEntity<Boolean> exists(@PathVariable Long id) {
//        return ResponseEntity.ok(categoryService.exists(id));
//    }
//
//    @GetMapping("count")
//    public ResponseEntity<Long> count() {
//        return ResponseEntity.ok(categoryService.count());
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public  void delete(@PathVariable Long id) {
//        categoryService.delete(id);
//    }
//
//    @GetMapping("page")
//    public ResponseEntity<Page<Category>> findPage(@RequestParam int page, @RequestParam int size,
//                                                   @RequestParam(required = false) String order,
//                                                   @RequestParam(required = false) Boolean asc) {
//        page = page - 1;
//        PageRequest pageRequest = PageRequest.of(page, size);
//        if (order != null && asc != null) {
//            pageRequest = PageRequest.of(page, size, asc ? Sort.Direction.ASC: Sort.Direction.DESC, order);
//        }
//        return ResponseEntity.ok(categoryService.findAll(pageRequest));
//    }
//}
