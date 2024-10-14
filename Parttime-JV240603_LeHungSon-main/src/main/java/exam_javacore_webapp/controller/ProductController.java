package exam_javacore_webapp.controller;

import exam_javacore_webapp.model.entity.Category;
import exam_javacore_webapp.model.entity.Product;
import exam_javacore_webapp.model.service.category.CategoryService;
import exam_javacore_webapp.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("product", products);
        return "product/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/add";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Product product, @RequestParam("imgFile") MultipartFile file) {
        //Xử lý upload
        String fileName = file.getOriginalFilename();
        String path = "D:\\kiemtramd3\\Parttime-JV240603_LeHungSon\\src\\main\\webappp\\uploads\\";
        File dest = new File(path + "/" + fileName);
        try{
            Files.write(dest.toPath(), file.getBytes(), StandardOpenOption.CREATE);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        product.setImage(fileName);
        if(productService.create(product)){
            return "redirect:/product";
        }
        return "product/add";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute Product product) {
        if(productService.update(product)){
            return "redirect:/product";
        }
        return "redirect:/product/edit/{id}";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
