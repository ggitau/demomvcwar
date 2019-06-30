package com.demo.mvc.demomvc.controllers;

import com.demo.mvc.demomvc.entity.Product;
import com.demo.mvc.demomvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @GetMapping("list")
    public String listProducts(Model model) {
        List<Product> products = productService.findAll(false);
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("new")
    public ModelAndView newProduct(@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return new ModelAndView("redirect:/products/list");
    }
}
