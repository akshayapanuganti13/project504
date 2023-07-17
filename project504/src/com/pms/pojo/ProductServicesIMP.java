package com.pms.pojo;
import java.util.List;

public class ProductServicesIMP  implements IProductService{

    private ProductDAO dao = new ProductDAO();

    public int addProduct(Product product){
        return dao.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return dao.updateProduct(product);
    }

    @Override
    public int deleteProductById(int pid) {
        return dao.deleteProductByNo(pid);
    }

    @Override
    public Product getProductById(int pid) {
        return dao.getProductByNo(pid);
    }

    @Override
    public List<Product> selectAll() {
        return dao.getAll();
    }
}