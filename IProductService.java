package com.pms.pojo;
import java.util.List;

public interface IProductService {
    public int addProduct(Product product);

    public int updateProduct(Product product);

    public int deleteProductById(int pid);

    public Product  getProductById(int pid);

    public List<Product> selectAll();
}