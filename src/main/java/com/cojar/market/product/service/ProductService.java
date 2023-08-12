package com.cojar.market.product.service;

import com.cojar.market.product.entity.Product;
import com.cojar.market.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public void create(String name, int price) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setCreateDate(LocalDateTime.now());
        this.productRepository.save(p);
    }

    public List<Product> getList() {
        return this.productRepository.findAll();
    }

    public Page<Product> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 8, Sort.by(sorts));
        return this.productRepository.findAll(pageable);
    }

    public Product getProduct(Long id) {
        Optional<Product> product = this.productRepository.findById(id);
        // TODO: 없을 경우 예외처리 예정
        return  product.get();
    }
}
