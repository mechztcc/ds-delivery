package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAllByOrderByNameAsc();
        //the content returned by stream() cannot be a list,
        // because of this, use Collectors.toList()
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
