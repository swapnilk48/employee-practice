package com.employee.practice.Controller;

import com.employee.practice.Entity.Product;
import com.employee.practice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final int PAGE_SIZE = 5;

    @Autowired
    private ProductRepository productRepository;

//    @GetMapping
//    public List<Product> findAll(@RequestParam(defaultValue = "id") String sortBy) {
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy));
//    }

    @GetMapping
    public Page<Product> findAll(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "0") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE,  Sort.by(Sort.Direction.ASC, sortBy));

        return productRepository.findAll(pageable);
    }

    @GetMapping("/nameContaining")
    List<Product> findByTitle(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "") String name,
                                @RequestParam(defaultValue = "0") Integer pageNumber) {

        return productRepository.findByNameContaining(name, PageRequest.of(pageNumber,
                PAGE_SIZE,
                Sort.by(Sort.Direction.ASC ,sortBy)));
    }
}
