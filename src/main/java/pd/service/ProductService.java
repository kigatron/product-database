package pd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pd.entity.Product;
import pd.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts (){
            return productRepository.findAll();


    }

    public String storeProduct(Product product) {
        Optional<Product> result=productRepository.findById(product.getPid());
        if(result.isPresent()) {
            return "Product id must be umique";
        }else{
                    productRepository.save(product);
                    return "Product record stored successfully";

        }
    }

    public String deleteProduct(int pid) {
        //Optional<Product> result=productRepository.findById(pid);
        if(productRepository.existsById(pid)) {
            productRepository.deleteById(pid);
            return "Product deleted successfully";
        }else{
            return "Product record not present";

        }
    }

    public Product searchProductById(int pid) {
        Optional<Product> result=productRepository.findById(pid);
        if(result.isPresent()) {
            Product product = result.get();
            return product;
        }else{
            return null;

        }
    }

    public String updateProduct(Product product) {
        Optional<Product> result=productRepository.findById(product.getPid());
        if(result.isPresent()) {
            Product p = result.get();
            p.setPname(product.getPname());
            p.setPrice(product.getPrice());
            productRepository.saveAndFlush(p);
            return "Product updated successfully";
        }else{
            return "Product record not present";

        }
    }

    public List<Object[] > orderDetails() {
        return productRepository.orderDetails();
    }
}
