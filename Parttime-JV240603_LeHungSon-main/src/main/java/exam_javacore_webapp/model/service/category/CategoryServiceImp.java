package exam_javacore_webapp.model.service.category;

import exam_javacore_webapp.model.dao.category.CategoryDAO;
import exam_javacore_webapp.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean create(Category category) {
        return categoryDAO.create(category);
    }

    @Override
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDAO.delete(id);
    }
}
