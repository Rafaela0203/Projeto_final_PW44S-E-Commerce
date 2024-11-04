package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.repository.CategoryRepository;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category, Long> implements ICategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {

        return categoryRepository;
    }
}
//    private CategoryRepository categoryRepository;
//
//    public CategoryServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public List<Category> findAll() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public Page<Category> findAll(Pageable pageable) {
//        return categoryRepository.findAll(pageable);
//    }
//
//    @Override
//    public Category save(Category category) {
//        return categoryRepository.save(category);
//    }
//
//    @Override
//    public Category findById(Long id) {
//        return categoryRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public boolean exists(Long id) {
//        return categoryRepository.existsById(id);
//    }
//
//    @Override
//    public long count() {
//        return categoryRepository.count();
//    }
//
//    @Override
//    public void delete(Long id) {
//        categoryRepository.deleteById(id);
//    }
//}
