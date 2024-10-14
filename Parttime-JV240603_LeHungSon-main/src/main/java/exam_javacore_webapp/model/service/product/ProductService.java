package exam_javacore_webapp.model.service.product;

import exam_javacore_webapp.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean create(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean delete(int id);
}
