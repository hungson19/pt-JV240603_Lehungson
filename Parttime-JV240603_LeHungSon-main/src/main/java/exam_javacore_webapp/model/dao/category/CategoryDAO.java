package exam_javacore_webapp.model.dao.category;

import exam_javacore_webapp.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    boolean create(Category category);
    Category findById(int id);
    boolean update(Category category);
    boolean delete(int id);
}
