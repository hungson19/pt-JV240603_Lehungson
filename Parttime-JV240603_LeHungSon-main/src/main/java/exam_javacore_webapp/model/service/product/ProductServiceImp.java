package exam_javacore_webapp.model.service.product;

import exam_javacore_webapp.model.dao.product.ProductDAO;
import exam_javacore_webapp.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean create(Product product) {
        return productDAO.create(product);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id);
    }
}
