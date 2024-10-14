package exam_javacore_webapp.model.dao.product;


import exam_javacore_webapp.model.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    boolean create(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean delete(int id);
}
