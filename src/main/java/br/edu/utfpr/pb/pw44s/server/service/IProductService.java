package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Product;

import java.util.List;

public interface IProductService extends IReadService<Product, Long>{
    List<Product> findByCategoryId(Long categoryId);
}
